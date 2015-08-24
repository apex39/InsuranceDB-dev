package com.domain.interactors;

import com.domain.exception.ErrorBundle;
import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.example.mateusz.insurancedb.model.Oc;
import com.domain.repository.OcRepository;

/**
 * Created by mateusz on 29.12.14.
 */
public class ModifyOcUseCaseImpl implements ModifyOcUseCase {

    private final OcRepository ocRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Oc oc;
    private ModifyOcUseCase.Callback callback;


    public ModifyOcUseCaseImpl(OcRepository ocRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        if(ocRepository == null || threadExecutor == null || postExecutionThread == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null.");
        }
        this.ocRepository = ocRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public void execute(Oc oc, Callback callback) {
        if(oc == null || callback == null) {
            throw new IllegalArgumentException("Null parameters.");
        }
        this.oc = oc;
        this.callback = callback;
        this.threadExecutor.execute(this);
    }

    @Override
    public void run() {
        this.ocRepository.modifyOc(this.oc, this.ocModifyCallback);
    }

    private OcRepository.OcModifyCallback ocModifyCallback = new OcRepository.OcModifyCallback() {
        @Override
        public void onOcModified() {
            notifyOcModifiedSuccessfully();
        }
        @Override
        public void onError(ErrorBundle errorBundle) {
            notifyError(errorBundle);
        }
    };

    private void notifyOcModifiedSuccessfully() {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onOcModified();
            }
        });
    }

    private void notifyError(final ErrorBundle errorBundle) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(errorBundle);
            }
        });
    }


}
