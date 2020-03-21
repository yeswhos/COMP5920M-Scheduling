public class pseudocode{
    //define counter for each LLH activations and the total activation
    public static int counter = 0;
    public static int counter1 = 0;
    public static int counter2 = 0;
    public static int counter3 = 0;
    public static int counter4 = 0;
    public static int counter5 = 0;
    public static int counter6 = 0;
    //method for initialize
    public static void initialize(int[] ranking){
        //Run each LLH independently for 10 times
        for(int i = 0; i < 10; i++){
            call LLH1;
        }
        //get the total constraint violations after 10 times LLH1
        total1 = getTotal();
        //numerical the performance of LLH1
        total1 = (total1 / 4027 /10) * 100; 
        //put it into the array, storing the ranking
        ranking.append(total1);
        //restart, prepare for the next LLH
        restart();

        //for LLH2 
        for(int i = 0; i < 10; i++){
            call LLH2;
        }
        total2 = getTotal();
        total2 = (total2 / 4027 /10) * 100; 
        ranking.append(total2);
        restart();

        //I wouldn't write all of them, cause it's the same for the rest LLHs initialization
    }
   
    //find the minimum, which is the best performance in the ranking array
    public static int findMin(int [] a){
        int min;
        int tmp = a[0];
        for(int i = 0; i < length.a - 1; i++){
            if(a[i] < tmp){
                min = i;
                tmp = a[i];
            }
        }
        return min;
    }

    //For those LLH who has not been selected for a while
    public static void rarely(){
        //if 10 attempts and none of them are LLH1, then assign 15 weight to it.
        if ((counter1 / counter) < 0.1){
            total1 += 15;
        }
        else if ((counter2 / counter) < 0.1){
            total1 += 15;
        }
        //I'm not gonna write all of it in here, cause they all the same
    }
    public static void restart(){

    }
    public static void main(String[] args){
        
        //array for storing ranking
        int [] ranking;
        //initialize
        initialize(ranking);

        //drop out of loop, until total constraint violation is smaller than 50
        do{
            //update total constraint violations
            int total = getTotal();
            //For those LLH who has not been selected for a while
            rarely();
            //find the minimum, which is the best performance in the ranking array
            findMin(ranking);
            switch(min){
                case 0:
                    call LLH1;
                    //update it's performance
                    //to judge it's performance is to use the total1 (newly total constraint violations) divide by the previous total
                    //then multiply 100 to make it as integer, then replace the corresponding number in the ranking array
                    total1 = (total1 / total) * 100;
                    ranking[0] = total1;
                    //update counter for LLH1
                    counter1++;
                    //update counter for all attempts
                    counter++;
                    break;
                case 1:
                    call LLH2;
                    //update it's performance
                    total2 = (total2 / total) * 100;
                    ranking[1] = total2;
                    counter2++;
                    counter++;
                    break;
                case 2:
                //the same as above
                case 3:
                //the same as above  
                case 4:
                //the same as above
                case 5:
                //the same as above
            }
            
        }while(total > 50);

    }



}
