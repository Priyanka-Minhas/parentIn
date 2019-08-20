package com.sdei.parentIn.interfaces;

public class InterfacesCall {
    public interface LocationInterface {
        void onresume();

        void onpause();
    }

    public  interface IndexClick{
        void clickIndex(int pos);
    }

    public  interface Callback{
        void selected(int pos);
    }

}
