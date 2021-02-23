//package com.example.petnet.Alogrithms;
import org.w3c.dom.ls.LSOutput;

import javax.print.DocFlavor;
import java.util.*;
import java.lang.*;
import java.io.*;


/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::                                                                         :*/
/*::  This routine calculates the distance between two points (given the     :*/
/*::  latitude/longitude of those points). It is being used to calculate     :*/
/*::  the distance between two locations using GeoDataSource (TM) products   :*/
/*::                                                                         :*/
/*::  Definitions:                                                           :*/
/*::    Southern latitudes are negative, eastern longitudes are positive     :*/
/*::                                                                         :*/
/*::  Function parameters:                                                   :*/
/*::    lat1, lon1 = Latitude and Longitude of point 1 (in decimal degrees)  :*/
/*::    lat2, lon2 = Latitude and Longitude of point 2 (in decimal degrees)  :*/
/*::    unit = the unit you desire for results                               :*/
/*::           where: 'M' is statute miles (default)                         :*/
/*::                  'K' is kilometers                                      :*/
/*::                  'N' is nautical miles                                  :*/
/*::  Worldwide cities and other features databases with latitude longitude  :*/
/*::  are available at https://www.geodatasource.com                         :*/
/*::                                                                         :*/
/*::  For enquiries, please contact sales@geodatasource.com                  :*/
/*::                                                                         :*/
/*::  Official Web site: https://www.geodatasource.com                       :*/
/*::                                                                         :*/
/*::           GeoDataSource.com (C) All Rights Reserved 2019                :*/
/*::                                                                         :*/
/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
class DistanceCalculator
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int numbers[] = {12,6,3};
        Arrays.sort(numbers);
        int j=0;
        int max = numbers[numbers.length-1];
        double ans=1;

        double arr[] = new double[numbers.length];
        for (int a =0; a< numbers.length;a++)
            arr[a] = numbers[a];

        for(double i=1.0;i<=max;i++) {
            j=0;
            while(j<numbers.length && arr[j]%i==0){
                j++;
            }
            if(j==numbers.length) {
                ans=i;
            }

        }

        System.out.println(ans);


    }






    static String[] answer = new String[120];
    static int count = 0;

    public static String[] allCodes() {
        String s = "12345";

        Permutation(s, "");

        String[] ans = new String[120];

        int i=0;

        for(String element:answer){
            ans[i++] = element;
        }

        return ans;
    }

    static void Permutation(String str, String ans)
    {

        if (str.length() == 0) {

            ans = ans.substring(0,4)+'#';

            answer[count++] = ans;

            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            String ros = str.substring(0, i)
                    + str.substring(i + 1);

            Permutation(ros, ans + ch);
        }
    }









    public static double npv(){
        double R = 20000;
        double i = 0.1;
        double ans = 0;
        for( int j = 1; j<20;j++){
            ans += R/Math.pow(1+i,j);
            if(ans-100000> 0) {
                System.out.println(ans);
                return j;
            }

        }
        return  0;
    }


    public static List permutationFinder(String str) {
        List perm = new ArrayList();
        //Handling error scenarios
        if (str == null) {
            return null;

        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        List words = permutationFinder(rem);
        for (int j =0; j<words.size();j++) {
            String strNew = (String)words.get(j);
            for (int i = 0; i<= strNew.length(); i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    static List ans ;
//    public static String[] allCodes(){
//        ans = new ArrayList();
//        String answer[] = new String[120];
//        String opt[] = new String[5];
//        opt[0] = "1234";
//        opt[1] = "1235";
//        opt[2] = "1345";
//        opt[3] = "2345";
//        opt[4] = "1245";
//
//
//        for(int i =0; i<opt.length;i++){
//            int index = 24;
//            int len = opt[i].length();
//            permute(opt[i],0,len-1);
//            for(int j = 0; j<ans.size();j++){
//                answer[index*i+j] = (String)ans.get(j);
//                answer[index*i+j]=answer[index*i+j].replaceAll(" ","");
//                ans = new ArrayList();
//            }
//
//
//        }
//
//
//
//
//        return answer;
//
//
//    }

    private static void permute(String str, int start , int end){
        if(start == end){
          //  ans.add(str);
            System.out.println(str + " ,count:" + count++);
        }
        else{
            for (int j = start; j <= end; j++ ){
                str = swap(str,start,j);
                permute(str,start+1,end);
                str = swap(str,start,j);
            }
        }
    }

    private static String swap(String s, int i, int j){

        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


    public static int clac(String form){
        int ans = 0;

        char temp;
        for(int i = form.length()-1; i>=0 ; i--){
            temp = form.charAt(i);
            if(temp>='0' && temp<='9'){
                ans = temp - '0';
            }
            else if(temp == 's'){
                ans = s(ans);
            }
            else if(temp == 'r'){
                ans = d(ans);
            }

        }
        return ans;

    }
    public static int s(int s){
        return s*2;
    }
    public static int d(int s){
        return s+1;
    }

    public static String sort(String num){
        String ans = "";
        int index;
        int arr[] = new int[9];
        for(int i = 0; i <num.length(); i ++){
            index = num.charAt(i) -'0';
            if(index!=0){
                arr[index-1]++;
            }
        }
        for(int i =0; i<arr.length;i++){
            int count = arr[i];
            while(count!=0){
                ans+=i+1;
                count--;
            }
        }
        return ans;
    }
    public static boolean isForm(String form){
        Stack st =  new Stack();
        boolean isDigit = false;
        char temp;
        for(int i = 0 ;i< form.length();i ++ ){
            temp = form.charAt(i);
            if(temp >= '0' && temp<='9') isDigit = true;
            if(temp == '(') st.push(temp);
            else if( temp == ')' && st.isEmpty() ) return false;
            else if(temp ==')') st.pop();
            else if(!(temp >= '0' && temp<='9') && temp!='s' && temp!='r') return false;

            if(i == form.length()-1 && isDigit==false)return false;

            if(i == form.length()-1 && st.isEmpty())return true;

        }
        return false;
    }



    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }
}