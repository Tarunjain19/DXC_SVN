package com.servion.cryptography;
//Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
//Jad home page: http://www.kpdus.com/jad.html
//Decompiler options: packimports(3) 
//Source File Name:   PINDecoder.java



public class PINDecoder
{

 public PINDecoder()
 {
 }

 public String deCode(String s, int i)
 {
     StringBuffer stringbuffer = new StringBuffer();
     try
     {
         int j = s.length();
         if(j > 15 || i > 15)
         {
             System.out.println("Incorrect PIN size for decoding");
             System.exit(-1);
         }
         if(j < i)
         {
             for(int k = 0; k < i - j; k++)
                 stringbuffer.append(0);

         }
         int ai[] = new int[i];
         int ai1[] = new int[i];
         for(int l = 0; l < j; l++)
         {
             char c = s.charAt(l);
             ai[l] = c;
         }

         for(int i1 = 0; i1 < ai.length; i1++)
             switch(ai[i1])
             {
             case 97: // 'a'
                 stringbuffer.append(0);
                 break;

             case 113: // 'q'
                 stringbuffer.append(0);
                 break;

             case 114: // 'r'
                 stringbuffer.append(1);
                 break;

             case 115: // 's'
                 stringbuffer.append(2);
                 break;

             case 116: // 't'
                 stringbuffer.append(3);
                 break;

             case 117: // 'u'
                 stringbuffer.append(4);
                 break;

             case 118: // 'v'
                 stringbuffer.append(5);
                 break;

             case 119: // 'w'
                 stringbuffer.append(6);
                 break;

             case 120: // 'x'
                 stringbuffer.append(7);
                 break;

             case 121: // 'y'
                 stringbuffer.append(8);
                 break;

             case 122: // 'z'
                 stringbuffer.append(9);
                 break;
             }

     }
     catch(Exception exception)
     {
         System.out.println("Error,Can't proccess");
     }
     String s1 = new String(stringbuffer);
     return s1;
 }
}
