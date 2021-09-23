import java.util.*;
class Video{
                    String vName;
                    boolean chkout;
                    int rate;

                Video(String name){
                            vName=name;
                               }

               public String getName(){
                            return vName; 
                              }
               public void doChkout(){
                           if(chkout==false)
	                chkout=true;
                             }

              public void doReturn(){
	              if(chkout==true)
	                    chkout=false;
                             }



              public void receiveRate(int rating){
                                       rate=rating;
                            }

                public int getRating(){
                                     return rate;
                              }

                  public boolean getChkout(){
                                          return chkout;
                                       }
             }

class VideoStore{
                                   static Video[] store=new Video[1000];
                                   static int i=0;
                                   static int max=20;
                                   static int j=0;

                            public void addVideo(String name){
                                                  System.out.println("Video \""+name+"\" added successfully.");  
                                                  Video v=new Video(name);
                                                   store[i]=v;
                                                   i++;
                                                  max=name.length()>max?name.length():max;
                                                    }

                          public void doChkout(String name){
	                                             int f=0;
	                                            for(j=0;j<i;j++)
	                                                  {
		                                    if(store[j].getName().equals(name)) {
			                                                                   f=1;
			                                                                  store[j].doChkout();
		                                                                  }
	                                                  }
	                                          if(f==1)	
		                                     System.out.println("Video \""+name+"\" checked out successfully.");
	                                           else
		                                    System.out.println("Video is not present in the inventory.");
                                                       }

                       public void doReturn(String name){
	                                                         int f=0;
	                                                        for(j=0;j<i;j++)
	                                                         {
		                                             if(store[j].getName().equals(name)) {
			                                                                             f=1;
			                                                                             store[j].doReturn();
		                                                                                 }
	                                                          }
	                                                      if(f==1)
		                                                 System.out.println("Video \""+name+"\" returned out successfully.");
	                                                      else
		                                                 System.out.println("Video is not present in the inventory.");
                                                                  }

                        public void receiveRating(String name,int rating){
	                                                                           int f=0;
	                                                                           for(j=0;j<i;j++)
	                                                                            {
		                                                                       if(store[j].getName().equals(name)) {
			                                                                                                         f=1;
			                                                                                                     store[j].receiveRate(rating);
		                                                                                            }
	                                                                               }
	                                                                          if(f==1)
	                                    	                                 System.out.println("Rating \""+rating+"\" has been mapped to the Video \""+name+"\".");
	                                                                           else
		                                                                    System.out.println("Video is not present in the inventory.");
	
                                                                                    }

                     public void listInventory(){
	                                                j=0;
	                                               for(int k=0;k<max;k++)
		                                              System.out.print("-");
	                                                System.out.println("------------------------------------------------------");
	                                                System.out.print("Video Name");
	                                                for(int k=0;k<max-10;k++)
		                                              System.out.print(" ");
	                                                System.out.println("|\t Checkout Status \t\t|\t Rating");
	
	                                                while(j<i)
	                                                  {
		                                   System.out.print(store[j].getName());
		                                   for(int k=0;k<max-store[j].getName().length();k++)
		                                    System.out.print(" ");
		                                    System.out.println("|\t"+store[j].getChkout()+"\t\t\t\t|\t  "+store[j].getRating());
		                                     j++;
	                                                   }
	                                              for(int k=0;k<max;k++)
		                                              System.out.print("-");
	                                              System.out.println("------------------------------------------------------");
                                                      }
                     }
public class VideoLauncher {
                     public static void main(String args[]){
                    Scanner sc=new Scanner(System.in);
                    VideoStore v=new VideoStore();
                     int ch=0;
                     String name;
                      int rate;
                  while(true)
                  {
                     System.out.println("MAIN MENU\n=========");
                     System.out.println("1.Add Videos :");
                     System.out.println("2.Check Out Video :");
                     System.out.println("3.Return Video :");
                     System.out.println("4.Receive Rating :");
                     System.out.println("5.List Inventory :");
                     System.out.println("6.Exit :");
                     System.out.print("Enter your choice(1..6) : "); 
                     ch=sc.nextInt();
                     switch(ch)
                     {
                       case 1: 
                                  System.out.print("Enter the name of the video you want to add: ");
                                  name=sc.next();
                                  v.addVideo(name);
                                  break;
                       case 2:
                               System.out.print("Enter the name of the video you want to check out: ");
                               name=sc.next();
                               v.doChkout(name);
                               break;
                       case 3:
                             System.out.print("Enter the name of the video you want to Return: ");
                             name=sc.next();
                             v.doReturn(name);
                             break;
                       case 4:
                                System.out.print("Enter the name of the video you want to Rate: ");
                                name=sc.next();
                                System.out.print("Enter the rating for this video: ");
                                rate=sc.nextInt();
                                 v.receiveRating(name,rate);
                                 break;
                       case 5: 
	                   v.listInventory();
	                    break;
                       case 6:
	                    System.out.println("Exiting...!! Thanks for using the application.");
                                     sc.close();
                                     System.exit(0);
                                     break;
                      default:
	                       System.out.println("Wrong choice.....Please choose again!!!!:");
                    }

              } 
       }
}


