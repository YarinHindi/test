import java.util.*;

public class Ex {

    // function to sort hashmap by values
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return -1*(o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static int kBallProb(int balls,int floors){
        int [][] temp = new int[balls +1][floors+1];
        for (int i = 1; i <balls+1 ; i++) { // for 0 or 1 balls.
            temp[i][0]=0;
            temp[i][1]=1;
        }
        for (int i = 1; i <floors+1 ; i++) {
            temp[1][i]=i;
        }
        for (int i = 2; i <temp.length ; i++) {
            for (int j = 2; j <temp[0].length ; j++) {
                temp[i][j]=Integer.MAX_VALUE;
                for (int k = 1; k <=j ; k++) {
                    int res = Math.max(temp[i-1][k-1],temp[i][j-k])+1;
                    if(temp[i][j]>res){
                        temp[i][j]=res;
                    }

                }
            }
        }
        return temp[balls][floors];
    }


    public static int kBallRec(int balls,int floors){
        if(floors==0 || floors==1) return floors;
        if(balls==1) return floors;
        int min = Integer.MAX_VALUE;
        int res;
        int x;
        for(x=1;x<=floors;x++){
            res=Math.max(kBallRec(balls,floors-x),kBallRec(balls-1,x-1));
            if(min>res) min=res;
        }
        return min;
    }

    // Driver Code
    public static void main(String[] args)
    {

        System.out.println(kBallProb(2,105));

   int players = 1111;
   int count =0;


   while(players!=1){
       count += players/2;
       if(players%2 == 1) {
           players = players/2 + 1;
       }
       else {
           players/=2;
       }


   }
        System.out.println(count);

//
//        HashMap<String, Integer> hm = new HashMap<String, Integer>();
//
//        // enter data into hashmap
//        hm.put("Math", 98);
//        hm.put("Data Structure", 85);
//        hm.put("Database", 91);
//        hm.put("Java", 95);
//        hm.put("Operating System", 79);
//        hm.put("Networking", 80);
//        Map<String, Integer> hm1 = sortByValue(hm);
//
//        // print the sorted hashmap
//        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
//            System.out.println("Key = " + en.getKey() +
//                    ", Value = " + en.getValue());
//        }
    }
}
