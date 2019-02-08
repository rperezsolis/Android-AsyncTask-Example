package com.prueba.movingthroughmatrix;

public class InterfaceDirection {

    interface View {
        void showProgressBar();
        void showResult(String result);
        void showError(String error);
    }

    interface Presenter {
        void getDirection(String rows, String columns);
        void showProgressBar();
        void showResult(String result);
        void showError(String error);
    }

    interface Model {
        void squared(String rows, String columns);
    }
}
