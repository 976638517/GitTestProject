package com.example.gittest.util;

import com.sun.org.apache.bcel.internal.generic.FSUB;
import org.apache.commons.compress.utils.Lists;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileDuplicateRemoval {
    public static String resultUrl="C:\\Users\\july\\Desktop\\dpInfo\\20201218\\1218";
    public static String sourcesUrl="C:\\Users\\july\\Desktop\\dpInfo\\20201218\\1217";
    public static String partUrl="C:\\Users\\july\\Desktop\\dpInfo\\20201217\\1217";


    public static void main(String[] args) throws IOException {
        List<String> list=getAllDerFile(resultUrl);
        for (String filename:
             list) {
            int index=filename.indexOf(".");
            filename=filename.substring(0, index);
            File file =new File("C:\\Users\\july\\Desktop\\dpInfo\\20201218\\json\\"+filename+".txt");
            if (!file.exists()){
                file.createNewFile();
            }
        }
    }

    /**
     * 从sourcesUrl中把不包含在partUrl的文件复制到resultUrl文件夹
     * @param resultUrl 存放结果的文件夹
     * @param sourcesUrl 存放全部文件的源文件夹
     * @param partUrl 存放要去重的文件的文件夹
     * @throws IOException
     */
    public static void fileRemoval(String resultUrl,String sourcesUrl,String partUrl) throws IOException {
        List<String> listAll=getAllDerFile(sourcesUrl);
        List<String> listPart=getAllDerFile(partUrl);
        List<String> result=removalList(listAll,listPart);
        for (String fileName:
             result) {
            File sourcesfile=new File(sourcesUrl+"\\"+fileName);
            File fileTarger=new File(resultUrl+"\\"+fileName);
            Files.copy(sourcesfile.toPath(),fileTarger.toPath());
        }
    }


    /**
     * 获取文件夹的下面的所有文件的名字
     * @param fileurl
     * @return
     */
    public static List<String> getAllDerFile(String fileurl){
        File file=new File(fileurl);
        File[] fs = file.listFiles();
        List<String> list= Lists.newArrayList();
        for(File f:fs){
            if(f.isFile()){
                list.add(f.getName());
            }
        }
        return list;
    }

    /**
     * 俩个list去重
     * 大list去除小list里面的重复
     * @param listAll 大list
     * @param listPart 小list
     * @return
     */
    public static List<String> removalList(List<String> listAll,List<String> listPart){
        for (int i=0;i<listAll.size();i++) {
            for (String strPart:
                 listPart) {
                if (listAll.get(i).equals(strPart))
                listAll.remove(i);
            }
        }
        return listAll;
    }
}
