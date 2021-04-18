import java.util.*;
import java.io.*;
class HashingString{
//Using  the fermit littl theoram     
static int modularinverse(int a,int b,int p){
 int ans=1;
 while(b!=0){
 if((b&1)==1){
 ans=(ans%p*a%p)%p;
 }
 a=(a%p*a%p)%p;
 b>>=1;
 }
 return ans;
}     
 public static void main(String[] args) {
 String m="ABCDE";
 //Use of the modular inverse topic
 String pattern="ABC";
 //Hash value of the pattern
int power[]=new int[pattern.length()];
power[0]=1;
int p=29;
int mod=3;
for(int i=1;i<=pattern.length()-1;++i){
power[i]=(power[i-1]*p)%mod;
}
//Calculate the hash value
int hash=0;
for(int i=0;i<pattern.length();++i){
    hash+=(power[i]*pattern.charAt(i))%mod;


}
int inverse=modularinverse(29, 1, 3);
for(int i=pattern.length();i<=m.length()-pattern.length();++i){
    hash=((hash-m.charAt(i))*inverse)%mod;
    hash+=(power[m.length()-1]*m.charAt(i))%mod;

}
 }

}