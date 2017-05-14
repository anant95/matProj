package matProj;
import java.io.*;
import java.net.*;
public class clientOne
{
  public static void main(String[] args) throws Exception
  {
      ServerSocket sersock = new ServerSocket(3000);
      System.out.println("Client one is ready");
      Socket sock = sersock.accept( );                          
                              // reading from keyboard (keyRead object)
      //BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
	                      // sending to client (pwrite object)
      OutputStream ostream = sock.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true);

                              // receiving from server ( receiveRead  object)
      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

      //String receiveMessage, sendMessage;  
/**********************************************************************************/
int m= Integer.valueOf(receiveRead.readLine());
int n= Integer.valueOf(receiveRead.readLine());
int q= Integer.valueOf(receiveRead.readLine());
//System.out.print(m+n+q);
int[][] mat1=new int[m][n];

for(int i=0;i<m;i++){
for(int j=0;j<n;j++){
mat1[i][j]=Integer.valueOf(receiveRead.readLine());
//System.out.print(mat1[i][j]+" ");
}
//System.out.print("\n");
}
int x;
if(q%2==0)
x=q/2;
else
x=(q/2)+1;
int[][] mat2=new int[n][x];
for(int k=0;k<x;k++){
for(int l=0;l<n;l++){
mat2[l][k]=Integer.valueOf(receiveRead.readLine());
//System.out.print(mat2[l][k]+" ");
}
//System.out.print("\n");
}
int mul,i;
for(int k=0;k<m;k++){
for(int l=0;l<x;l++){
mul=0;
i=0;
for(i=0;i<n;i++){
mul=mul+mat1[k][i]*mat2[i][l];
}
pwrite.println(mul);
pwrite.flush();
//System.out.print(mul+" ");
}

}
for(i=0;i<n;i++){
for(int j=0;j<x;j++){
System.out.print(mat2[i][j]+" ");

}
System.out.print("\n");
}
sersock.close();
/************************************************************************************             
      while(true)
      {
        if((receiveMessage = receiveRead.readLine()) != null)  
        {
           System.out.println(receiveMessage);         
        }         
        sendMessage = keyRead.readLine(); 
        pwrite.println(sendMessage);             
        pwrite.flush();
      }               
**************************************************************************************/
    }                    
}                        