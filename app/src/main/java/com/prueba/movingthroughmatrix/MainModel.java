package com.prueba.movingthroughmatrix;

import android.os.AsyncTask;

public class MainModel implements InterfaceDirection.Model {
    private InterfaceDirection.Presenter presenter;
    private static final int R = 0;
    private static final int L = 1;
    private static final int U = 2;
    private static final int D = 3;

    public MainModel(InterfaceDirection.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void squared(String rows, String columns) {
        if (rows.equals("") || columns.equals("")){
            presenter.showError("Fill the two fields please");
        } else {
            new BackgroundThread().execute(Integer.parseInt(rows), Integer.parseInt(columns));
        }
    }

    private void setDirection(Integer result){
        switch(result){
            case R:
                presenter.showResult("Right");
                break;
            case L:
                presenter.showResult("Left");
                break;
            case U:
                presenter.showResult("Up");
                break;
            case D:
                presenter.showResult("Down");
                break;
        }
    }

    private class BackgroundThread extends AsyncTask<Integer, Void, Integer> {
        @Override
        protected Integer doInBackground(Integer... integers) {
            presenter.showProgressBar();
            int i, r=0, c=0, direction = MainModel.R;
            int rows = integers[0];
            int columns = integers[1];
            while(r<rows && c<columns){

                for(i=c; i<columns; i++){ //moving to the rigth
                    direction = R;
                }
                r++;

                for(i=r; i<rows; i++){ //moving down
                    direction = D;
                }
                columns--;

                if(r<rows){
                    for(i=columns-1; i>=c; --i){ //moving to the left
                        direction = L;
                    }
                    rows--;
                }

                if(c<columns){
                    for(i=rows-1; i>=r; --i){ //moving up
                        direction = U;
                    }
                    c++;
                }

            }
            return direction;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            setDirection(integer);
        }
    }
}
