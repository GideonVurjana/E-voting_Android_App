package com.eddrix.project.evoting.config;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences {

    private static final String PREFERENCES_NAME = "EVOTING_CONFIG";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public MyPreferences(Context context){
        sharedPreferences=context.getSharedPreferences(PREFERENCES_NAME,0);
        editor= sharedPreferences.edit();

    }

    public void setRollNo(String rollnumber) {
        editor.putString("rollnumber",rollnumber);
        editor.apply();

    }
    public String getRollNo(){
        return sharedPreferences.getString("rollnumber",null);
    }

    public void setUserType(int usertype) {
        editor.putInt("usertype",usertype);
        editor.apply();

    }
    public int getUserType(){
        return sharedPreferences.getInt("usertype",0);
    }
    public void setUsertypeInfo(String typename) {
        editor.putString("typename",typename);
        editor.apply();

    }
    public String getUserTypeInfo(){
        return sharedPreferences.getString("typename",null);
    }

    public void setStudentRole(String studentROLE) {
        editor.putString("STUDENT_ROLE",studentROLE);
        editor.apply();
    }

    public String getStudentRole(){
        return sharedPreferences.getString("STUDENT_ROLE",null);
    }
    public void setBranch(String branchname) {
        editor.putString("BRANCH",branchname);
        editor.apply();

    }
    public String getBranch(){
        return sharedPreferences.getString("BRANCH",null);
    }

    public void setPhone(String phone) {
        editor.putString("PHONE",phone);
        editor.apply();
    }
    public String getPhone(){
        return sharedPreferences.getString("PHONE",null);
    }
    public void setDP(String filename) {
        editor.putString("DP_PIC",filename);
        editor.apply();
    }
    public String getDP(){
        return sharedPreferences.getString("DP_PIC",null);
    }

    public void setFacultyRole(String facultyRole) {

        editor.putString("FACULTY_ROLE",facultyRole);
        editor.apply();
    }
    public String getFacultyRole(){
        return sharedPreferences.getString("FACULTY_ROLE",null);
    }

    public void setProgram(String programname) {
        editor.putString("PROGRAM",programname);
        editor.apply();
    }
    public String getProgram(){
        return sharedPreferences.getString("PROGRAM",null);
    }


    public void setYear(String yearname) {
        editor.putString("YEAR",yearname);
        editor.apply();
    }


    public String getYear(){
        return sharedPreferences.getString("YEAR",null);
    }




    public void setUserPrimaryAddress(String userPrimaryAddress){
        editor.putString("USER_PRIMARY_ADDRESS",userPrimaryAddress);
        editor.apply();
    }
    public String getUserPrimaryAddress(){
        return sharedPreferences.getString("USER_PRIMARY_ADDRESS",null);
    }
    public void setBio(String bio) {
        editor.putString("BIO",bio);
        editor.apply();

    }

    public  String getBio(){

        return sharedPreferences.getString("BIO",null);
    }


    public  void setDP_String(String fn){
        editor.putString("DP_STR",fn);
        editor.apply();
    }
    public String getDP_String(){
        return sharedPreferences.getString("DP_STR",null);
    }


    public  void setDob(String f){
        editor.putString("DOB",f);
        editor.apply();
    }
    public String getDOB(){
        return sharedPreferences.getString("DOB",null);
    }


    public  void setGender(int fn){
        editor.putInt("GENDER",fn);
        editor.apply();
    }
    public int getGender(){
        return sharedPreferences.getInt("GENDER",0);
    }


    public  void setFirstName(String fn){
        editor.putString("FN",fn);
        editor.apply();
    }
    public String getFirstName(){
        return sharedPreferences.getString("FN",null);
    }

    public  void setLastName(String fn){
        editor.putString("LN",fn);
        editor.apply();
    }
    public String getLastName(){
        return sharedPreferences.getString("LN",null);
    }


    public  void setUID(String UID){
        editor.putString("UID",UID);
        editor.apply();
    }
    public String getUID(){
        return sharedPreferences.getString("UID",null);
    }

    public boolean isStudent(){
        return sharedPreferences.getBoolean("IS_STUDENT",false);
    }


    public  void set_isStudent(boolean isStudent){
        editor.putBoolean("IS_STUDENT",isStudent);
        editor.apply();

    }
    public void setVerified(boolean status){
        editor.putBoolean("VERIFIED",status);
        editor.apply();
    }
    public boolean getVerified(){
        return sharedPreferences.getBoolean("VERIFIED",false);
    }

    public void setFireBaseToken(String token){
        editor.putString("TOKEN",token);
        editor.apply();
    }

    public String getFireBaseToken(){
        return  sharedPreferences.getString("TOKEN",null);
    }



    public void setUserName(String userName){
        editor.putString("USERNAME",userName);
        editor.apply();
    }



    public String getUserName(){
        return  sharedPreferences.getString("USERNAME",null);
    }

    public void tokenChanged(boolean s){

        editor.putBoolean("TOKEN_CHANGED",s);
        editor.apply();

    }
    public boolean isTokenChanged(){

        return sharedPreferences.getBoolean("TOKEN_CHANGED",false);
    }












}
