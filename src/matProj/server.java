package matProj;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class server
{
  public static void main(String[] args) throws Exception
  {
     Socket sock = new Socket("localhost", 3000);
                               // reading from keyboard (keyRead object)
    // BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
                              // sending to client (pwrite object)
     OutputStream ostream = sock.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(ostream, true);

                              // receiving from server ( receiveRead  object)
     InputStream istream = sock.getInputStream();
     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
Socket sock1 = new Socket("localhost", 3001);
OutputStream ostream1 = sock1.getOutputStream(); 
     PrintWriter pwrite1 = new PrintWriter(ostream1, true);

                              // receiving from server ( receiveRead  object)
     InputStream istream1 = sock1.getInputStream();
     BufferedReader receiveRead1 = new BufferedReader(new InputStreamReader(istream1));
     

     //String receiveMessage, sendMessage,receiveMessage1, sendMessage1;   
/******************************************************************/
Scanner sc=new Scanner(new File("test.txt"));
		int m=sc.nextInt();
		int n=sc.nextInt();
		
		int p=sc.nextInt();
		int q=sc.nextInt();
		
		int[][] mat1=new int[m][n];
		int[][] mat2=new int[p][q];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
			mat1[i][j]=sc.nextInt();
		}
		for(int i=0;i<p;i++){
			for(int j=0;j<q;j++)
			mat2[i][j]=sc.nextInt();
		}
		
		sc.close();
		System.out.println("Data is read by server from test.txt");
int[][] ans=new int[m][q];
pwrite.println(m);
pwrite.flush();
pwrite.println(n);
pwrite.flush();
pwrite.println(q);
pwrite.flush();
//int z= Integer.valueOf(receiveRead.readLine());
//System.out.println(z);

pwrite1.println(m);
pwrite1.flush();
pwrite1.println(n);
pwrite1.flush();
pwrite1.println(q);
pwrite1.flush();
//int z1= Integer.valueOf(receiveRead1.readLine());
for(int i=0;i<m;i++){
  for(int j=0;j<n;j++){
   pwrite.println(mat1[i][j]);
   pwrite.flush();
   pwrite1.println(mat1[i][j]);
   pwrite1.flush();
}
}
  for(int k=0;k<q;k++){
   for(int l=0;l<n;l++){
    pwrite.println(mat2[l][k]);
    pwrite.flush();
}
    k++;
  if(k<q){
   for(int l=0;l<n;l++){
    pwrite1.println(mat2[l][k]);
    pwrite1.flush();
}
}
   
}
for(int i=0;i<m;i++){
for(int j=0;j<q;j++){
ans[i][j]=Integer.valueOf(receiveRead.readLine());
j++;
if(j<q)
ans[i][j]=Integer.valueOf(receiveRead1.readLine());
}
}
for(int i=0;i<m;i++){
for(int j=0;j<q;j++){
System.out.print(ans[i][j]+" ");
}
System.out.print("\n");
}
sock.close();
sock1.close();
	/*********************************************************	            
     while(true)
     {
        sendMessage = keyRead.readLine();  // keyboard reading
        pwrite.println(sendMessage);       // sending to server
        pwrite.flush();                    // flush the data
        if((receiveMessage = receiveRead.readLine()) != null) //receive from server
        {
            System.out.println(receiveMessage); // displaying at DOS prompt
        }         
      }               
*********************************************************************/
    }                    
}                        