package com.example.kendryayu.kendryayu_1202160048_si4008_pab_modul5;

public class Methods {
    public void setColorTheme(){

        switch (Constant.color){
            case 0xffFF9800:
                Constant.theme = R.style.AppTheme;
                break;
            case 0xff9E9E9E:
//                Constant.theme = R.style.AppTheme_black;
                break;
            default:
                Constant.theme = R.style.AppTheme;
                break;
        }
    }
}
