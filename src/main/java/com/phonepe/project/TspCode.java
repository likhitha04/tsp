package com.phonepe.project;

import java.util.Random;

public class TspCode {
  int v;
  int m[][];
  int cost=10000;
  TspCode(int v)
  {
    this.v=v;
    m = new int[v][v];
    for(int i=0;i<v;i++)
    m[i][i]=0;
    for(int i=0;i<v;i++)
    {
      for(int j=0;j<v;j++)
      {
        if(i!=j)
        m[i][j]=new Random().nextInt(50) + 1;
      }
    }

  }
  void permute(int[] a,int i,int v)
  {
    int j;
    if(i==v)
    {
      int sum=0;
      for(int k=0;k<=v;k++)
      {
        sum=sum+m[a[k%(v+1)]][a[(k+1)%(v+1)]];
      }
      if(sum<cost)
        cost=sum;
    }
    for(j=i;j<=v;j++)
    {
      int temp=a[i];
      a[i]=a[j];
      a[j]=temp;
      permute(a,i+1,v);
      temp=a[i];
      a[i]=a[j];
      a[j]=temp;
    }
  }

  public static void main(String[] args) {
    Integer v = Integer.parseInt(args[0]);
   // System.out.println(v);
    TspCode g = new TspCode(v);
    int[] a;
    a=new int[v];
    for(int i=0;i<v;i++)
    {
      a[i]=i;
    }
    g.permute(a,1,v-1);
    System.out.println(g.cost);
  }
}
