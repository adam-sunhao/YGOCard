package com.test;

import com.test.ui.MainFrame;

/**
 * 项目入口类
 * @author sunhao
 */
public class Main {
    public static void main(String[] args) {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
        }
        new MainFrame();
    }
}