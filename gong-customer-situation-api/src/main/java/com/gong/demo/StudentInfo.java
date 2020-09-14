package com.gong.demo;

import com.google.gson.Gson;
import jodd.util.CollectionUtil;
import org.nustaq.serialization.annotations.Flat;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 1.学生总分进行倒序排列
 * 2.总分相同数学成绩倒序排列
 * 3.数学成绩相同，按录入顺序正序排列
 *
 * 主要利用稳定性排序规则
 */
public class StudentInfo {

    //姓名
    private String name;

    //语文
    private Float yuwenScore;

    //数学
    private Float shuxueScore;

    //外语
    private Float waiyuScore;

    //录入序号
    private int sort;

    //总分
    private Float totalScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getYuwenScore() {
        return yuwenScore;
    }

    public void setYuwenScore(Float yuwenScore) {
        this.yuwenScore = yuwenScore;
    }

    public Float getShuxueScore() {
        return shuxueScore;
    }

    public void setShuxueScore(Float shuxueScore) {
        this.shuxueScore = shuxueScore;
    }

    public Float getWaiyuScore() {
        return waiyuScore;
    }

    public void setWaiyuScore(Float waiyuScore) {
        this.waiyuScore = waiyuScore;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }


    public StudentInfo(String name,Float yuwenScore,Float shuxueScore,Float waiyuScore,Float totalScore,int sort){
        this.name = name;
        this.yuwenScore = yuwenScore;
        this.shuxueScore = shuxueScore;
        this.waiyuScore = waiyuScore;
        this.totalScore = totalScore;
        this.sort = sort;
    }


    public static void main(String[] args) {


        List<StudentInfo> inValues = new ArrayList<>();
        inValues.add(new StudentInfo("gyk",99f,87f,98f,284f,1));
        inValues.add(new StudentInfo("gyk1",99f,87f,98f,284f,2));
        inValues.add(new StudentInfo("gyk2",99f,88f,98f,285f,3));
        inValues.add(new StudentInfo("gyk3",99f,88f,97f,284f,4));

        /**
         * 1.学生总分进行倒序排列
         * 2.总分相同数学成绩倒序排列
         * 3.数学成绩相同，按录入顺序正序排列
         *
         * 主要利用稳定性排序规则
         */
        inValues = inValues.stream().sorted(Comparator.comparing(StudentInfo::getSort)).collect(Collectors.toList());
        inValues = inValues.stream().sorted(Comparator.comparing(StudentInfo::getShuxueScore).reversed()).collect(Collectors.toList());
        inValues = inValues.stream().sorted(Comparator.comparing(StudentInfo::getTotalScore).reversed()).collect(Collectors.toList());

        inValues.forEach(data->{
            System.out.println(new Gson().toJson(data));
        });


        //学生人数
        int studentNum = 0;
//        Scanner scanner = new Scanner(System.in);

//        while (scanner.hasNext()){
            //学生人数小于40
//            if (inValues.size()<=0 && Integer.valueOf(scanner.next())<40){
//                studentNum = Integer.valueOf(scanner.next());
//            }else {
//                if (inValues.size()<=studentNum){
//                    String[] s = scanner.next().split(" ");
//                    StudentInfo studentInfo = new StudentInfo();
//                    studentInfo.setName(s[0]);
//                    studentInfo.setYuwenScore(Integer.valueOf(s[1]));
//                    studentInfo.setShuxueScore(Integer.valueOf(s[2]));
//                    studentInfo.setWaiyuScore(Integer.valueOf(s[3]));
//                    studentInfo.setSort(inValues.size()+1);
//                    studentInfo.setTotalScore(Integer.valueOf(s[1])+Integer.valueOf(s[2])+Integer.valueOf(s[3]));
//                    inValues.add(studentInfo);
//                }
//            }
//            String[] s = scanner.next().split(" ");
//            StudentInfo studentInfo = new StudentInfo();
//            studentInfo.setName(s[0]);
//            studentInfo.setYuwenScore(Integer.valueOf(s[1]));
//            studentInfo.setShuxueScore(Integer.valueOf(s[2]));
//            studentInfo.setWaiyuScore(Integer.valueOf(s[3]));
//            studentInfo.setSort(inValues.size()+1);
//            studentInfo.setTotalScore(Integer.valueOf(s[1])+Integer.valueOf(s[2])+Integer.valueOf(s[3]));
//            inValues.add(studentInfo);
//        }



    }



}
