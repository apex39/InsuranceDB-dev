package com.domain.interactors;

import com.domain.exception.ErrorBundle;
import com.domain.executor.PostExecutionThread;
import com.domain.executor.ThreadExecutor;
import com.domain.repository.OcRepository;

/**
 * Created by mateusz on 29.12.14.
 */
public class RemoveOcUseCaseImpl implements RemoveOcUseCase {
    private final OcRepository ocRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private RemoveOcUseCase.Callback callback;
    private int ocId;

    public RemoveOcUseCaseImpl(OcRepository ocRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        if(ocRepository == null || threadExecutor == null || postExecutionThread == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null.");
        }
        this.ocRepository = ocRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }
    @Override
    public void execute(final int ocId, Callback callback) {
        if(ocId < 0 || callback == null) {
            throw new IllegalArgumentException("Null parameter.");
        }
        this.ocId = ocId;
        this.callback = callback;
        this.threadExecutor.execute(this);
    }

    @Override
    public void run() {
        this.ocRepository.removeOc(this.ocId, this.repositoryCallback);
    }
    private OcRepository.OcRemoveCallback repositoryCallback = new OcRepository.OcRemoveCallback() {
        @Override
        public void onOcRemoved() {
            notifyOcRemovedSuccessfully();
        }

        @Override
        public void onError(ErrorBundle errorBundle) {
            notifyError(errorBundle);
        }
    };

    private void notifyOcRemovedSuccessfully() {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onOcRemoved();
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
