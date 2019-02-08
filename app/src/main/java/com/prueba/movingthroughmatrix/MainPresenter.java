package com.prueba.movingthroughmatrix;

public class MainPresenter implements InterfaceDirection.Presenter {
    private InterfaceDirection.View view;
    private InterfaceDirection.Model model;

    public MainPresenter(InterfaceDirection.View view){
        this.view = view;
        model = new MainModel(this);
    }

    @Override
    public void getDirection(String rows, String columns) {
        if (view!=null){
            model.squared(rows, columns);
        }
    }

    @Override
    public void showProgressBar() {
        if (view!=null){
            view.showProgressBar();
        }
    }

    @Override
    public void showResult(String result) {
        if (view!=null){
            view.showResult(result);
        }
    }

    @Override
    public void showError(String error) {
        if (view!=null){
            view.showError(error);
        }
    }
}
