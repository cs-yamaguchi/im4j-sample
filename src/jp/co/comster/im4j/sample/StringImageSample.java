package jp.co.comster.im4j.sample;

import java.io.File;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

public class StringImageSample {


    public static void main(String[] args) throws Exception {

    	String basePath = System.getProperty("user.dir");
    	String inimg = basePath + "/img/icon_maitama.jpg";
    	String outimg = basePath + "/img/icon_maitama_str_out.jpg";

        File src = new File(inimg);
        File dest = new File(outimg);


        ConvertCmd cmd = new ConvertCmd();
        cmd.setSearchPath("C:\\usr\\bin\\ImageMagick-6.9.2-7-portable-Q16-x86");

        IMOperation op = new IMOperation(); //imagemagick operator for command line tools

        //draw method
        op.addImage(src.getAbsolutePath());
//        op.resize(957, 626); //resizing image
        op.pointsize(200); //size of text
//        op.font("Times-New-Roman"); // font
        op.font(basePath + "/font/ArmedBanana.ttf"); // font
//        op.font(basePath + "/font/MEIRYO.TTC"); // font
//        op.fill("Black"); //font color
        op.fill("Red"); //font color
        op.draw("text 100,300 '↓　けんじ'"); // location of text, actual text
        op.addImage(dest.getAbsolutePath());
        cmd.run(op);
    }

}
