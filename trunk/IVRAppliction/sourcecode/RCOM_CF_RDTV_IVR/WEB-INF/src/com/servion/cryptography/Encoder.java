package com.servion.cryptography;

//Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
//Jad home page: http://www.kpdus.com/jad.html
//Decompiler options: packimports(3)
//Source File Name:   Encoder.java


import java.io.*;

//Referenced classes of package Encoder:
//         ProcessingData

public class Encoder
{

 public Encoder()
 {
     pd = new ProcessingData();
 }

 public String enCode(String s)
 {
     String s1 = new String();
     String s2 = new String();
     String s6 = new String();
     StringBuffer stringbuffer = new StringBuffer();
     int i = 0;
     int j2 = 0;
     int k2 = 0;
     String s9 = new String();
     s1 = s.substring(0, s.length());
     pd.strLengthOfPin = s1.length();
     splitNumberChars = pd.strLengthOfPin / 2;
     if(s1.length() > 15 || s1.length() < 12)
     {
         System.out.println((new StringBuffer()).append("Passed PIN length = ").append(s1.length()).toString());
         return "UnSupported Pin Size: Between 12-15 digits only.";
     }
     System.out.println((new StringBuffer()).append("PIN = ").append(s1).append(" and length ").append(pd.strLengthOfPin).toString());
label0:
     switch(pd.strLengthOfPin / splitNumberChars)
     {
     case 0: // '\0'
         System.out.println("Case 0");
         String s3 = s1.substring(0, pd.strLengthOfPin);
         long l = (new Long(s3)).longValue();
         l ^= pd.xorseq;
         pd.fst = l * pd.magicNum;
         pd.scd ^= pd.xorseq;
         pd.scd *= pd.magicNum;
         Long long1 = new Long(pd.fst);
         String s10 = long1.toString();
         System.out.print((new StringBuffer()).append("pds are ").append(pd.fst).toString());
         for(; i < s10.length(); i++)
         {
             int j = 65 + s10.charAt(i);
             stringbuffer.append((char)j);
         }

         break;

     case 1: // '\001'
         String s4;
         for(s4 = s1.substring(0, splitNumberChars); k2 < s4.length() && s4.charAt(k2) == '0'; k2++);
         long l1 = (new Long(s4)).longValue();
         l1 ^= pd.xorseq;
         pd.fst = l1 * pd.magicNum;
         if(pd.strLengthOfPin > splitNumberChars)
         {
             int i3 = splitNumberChars;
             String s7;
             for(s7 = s1.substring(splitNumberChars, pd.strLengthOfPin); i3 < s7.length() && s7.charAt(i3) == '0'; i3++)
                 j2++;

             long l3 = (new Long(s7)).longValue();
             l3 ^= pd.xorseq;
             pd.scd = l3 * pd.magicNum;
         } else
         {
             pd.scd ^= pd.xorseq;
             pd.scd *= pd.magicNum;
         }
         Long long2 = new Long(pd.fst);
         String s11 = long2.toString();
         Long long4 = new Long(pd.scd);
         if(pd.strLengthOfPin > splitNumberChars)
             s11 = (new StringBuffer()).append(s11).append(long4.toString()).toString();
         do
         {
             if(i >= s11.length())
                 break label0;
             if(j2 == 0)
             {
                 int k = 65 + s11.charAt(i);
                 stringbuffer.append((char)k);
                 i++;
             } else
             if(j2 != 0 && i >= splitNumberChars && i < pd.strLengthOfPin)
             {
                 for(; j2 != 0; j2--)
                 {
                     byte byte0 = 97;
                     stringbuffer.append((char)byte0);
                     i++;
                 }

                 if(i < pd.strLengthOfPin)
                 {
                     int i1 = 65 + s11.charAt(i);
                     stringbuffer.append((char)i1);
                     i++;
                 }
             }
         } while(true);

     case 2: // '\002'
         String s5;
         for(s5 = s1.substring(0, splitNumberChars); k2 < s5.length() && s5.charAt(k2) == '0'; k2++);
         long l2 = (new Long(s5)).longValue();
         l2 ^= pd.xorseq;
         pd.fst = l2 * pd.magicNum;
         String s8 = s1.substring(splitNumberChars, pd.strLengthOfPin);
         long l4 = (new Long(s8)).longValue();
         l4 ^= pd.xorseq;
         pd.scd = l4 * pd.magicNum;
         for(int j3 = 0; j3 < pd.strLengthOfPin - splitNumberChars && s8.charAt(j3) == '0'; j3++)
             j2++;

         Long long3 = new Long(pd.fst);
         String s12 = long3.toString();
         Long long5 = new Long(pd.scd);
         s12 = (new StringBuffer()).append(s12).append(long5.toString()).toString();
         if(j2 == 0)
         {
             for(; i < s12.length(); i++)
             {
                 int j1 = 65 + s12.charAt(i);
                 stringbuffer.append((char)j1);
             }

             break;
         }
         int k3;
         for(k3 = 0; i < splitNumberChars - k2; k3++)
         {
             int k1 = 65 + s12.charAt(i);
             stringbuffer.append((char)k1);
             i++;
         }

         while(j2 != 0)
         {
             byte byte1 = 97;
             stringbuffer.append((char)byte1);
             j2--;
             k3++;
         }
         for(; i < s12.length() && k3 < 15; i++)
         {
             int i2 = 65 + s12.charAt(i);
             stringbuffer.append((char)i2);
         }

         break;

     default:
         System.err.println("Unsupported Pin Size");
         break;
     }
     String s13 = new String(stringbuffer);
     return s13;
 }

 public Encoder(BufferedReader bufferedreader)
     throws IOException
 {
     fout = new FileWriter("C://Prashant//Encode//Jtest.txt", true);
     PrintWriter printwriter = new PrintWriter(fout, false);
     String s = new String();
     do
     {
         String s1;
         if((s1 = bufferedreader.readLine()) == null)
             break;
         pd = new ProcessingData();
         String s2 = new String();
         String s3 = new String();
         String s7 = new String();
         long l = 0L;
         long l4 = 0L;
         int i = 0;
         int k = 0;
         int j3 = 0;
         boolean flag = false;
         String s10 = new String();
         s2 = s1.substring(0, s1.length());
         pd.strLengthOfPin = s2.length();
         switch(pd.strLengthOfPin / splitNumberChars)
         {
         case 0: // '\0'
             System.out.println("Case 0");
             String s4 = s2.substring(0, pd.strLengthOfPin);
             long l1 = (new Long(s4)).longValue();
             l1 ^= pd.xorseq;
             pd.fst = l1 * pd.magicNum;
             pd.scd ^= pd.xorseq;
             pd.scd *= pd.magicNum;
             Long long1 = new Long(pd.fst);
             String s11 = long1.toString();
             System.out.print((new StringBuffer()).append("pds are ").append(pd.fst).append("  ").append(pd.scd).toString());
             if(pd.strLengthOfPin <= splitNumberChars)
             {
                 for(; i < s11.length(); i++)
                 {
                     int i1 = 65 + s11.charAt(i);
                     printwriter.print((char)i1);
                 }

                 printwriter.println();
             } else
             {
                 System.out.print((new StringBuffer()).append("Encodestr after1").append(s11).toString());
                 Long long4 = new Long(pd.scd);
                 s11 = (new StringBuffer()).append(s11).append(long4.toString()).toString();
                 System.out.print((new StringBuffer()).append("Encodestr after2").append(s11).toString());
                 for(; i < s11.length(); i++)
                 {
                     int j1 = 65 + s11.charAt(i);
                     printwriter.print((char)j1);
                 }

                 printwriter.println();
             }
             break;

         case 1: // '\001'
             String s5;
             for(s5 = s2.substring(0, splitNumberChars); s5.charAt(k) == '0'; k++);
             long l2 = (new Long(s5)).longValue();
             l2 ^= pd.xorseq;
             pd.fst = l2 * pd.magicNum;
             if(pd.strLengthOfPin > splitNumberChars)
             {
                 int k3 = splitNumberChars;
                 String s8;
                 for(s8 = s2.substring(splitNumberChars, pd.strLengthOfPin); k3 < s8.length() && s8.charAt(k3) == '0'; k3++)
                     j3++;

                 long l5 = (new Long(s8)).longValue();
                 l5 ^= pd.xorseq;
                 pd.scd = l5 * pd.magicNum;
             } else
             {
                 pd.scd ^= pd.xorseq;
                 pd.scd *= pd.magicNum;
             }
             Long long2 = new Long(pd.fst);
             String s12 = long2.toString();
             Long long5 = new Long(pd.scd);
             s12 = (new StringBuffer()).append(s12).append(long5.toString()).toString();
             do
             {
                 if(i >= pd.strLengthOfPin)
                     break;
                 if(j3 == 0)
                 {
                     int k1 = 65 + s12.charAt(i);
                     printwriter.print((char)k1);
                     i++;
                 } else
                 if(j3 != 0 && i >= splitNumberChars && i < pd.strLengthOfPin)
                 {
                     for(; j3 != 0; j3--)
                     {
                         byte byte0 = 97;
                         printwriter.print((char)byte0);
                         i++;
                     }

                     if(i < pd.strLengthOfPin)
                     {
                         int i2 = 65 + s12.charAt(i);
                         System.out.print((new StringBuffer()).append("Character is ").append((char)i2).toString());
                         printwriter.print((char)i2);
                         i++;
                     }
                 }
             } while(true);
             printwriter.println();
             break;

         case 2: // '\002'
             System.out.println("Inside case 2");
             String s6 = s2.substring(0, splitNumberChars);
             System.out.println((new StringBuffer()).append("First string ").append(s6).toString());
             for(; k < s6.length() && s6.charAt(k) == '0'; k++);
             long l3 = (new Long(s6)).longValue();
             l3 ^= pd.xorseq;
             pd.fst = l3 * pd.magicNum;
             String s9 = s2.substring(splitNumberChars, 15);
             long l6 = (new Long(s9)).longValue();
             l6 ^= pd.xorseq;
             pd.scd = l6 * pd.magicNum;
             for(int i4 = 0; i4 < splitNumberChars && s9.charAt(i4) == '0'; i4++)
                 j3++;

             Long long3 = new Long(pd.fst);
             String s13 = long3.toString();
             Long long6 = new Long(pd.scd);
             s13 = (new StringBuffer()).append(s13).append(long6.toString()).toString();
             int j = 0;
             if(j3 == 0)
             {
                 for(; j < s13.length(); j++)
                 {
                     int j2 = 65 + s13.charAt(j);
                     printwriter.print((char)j2);
                 }

             } else
             {
                 int j4;
                 for(j4 = 0; j < splitNumberChars - k; j4++)
                 {
                     int k2 = 65 + s13.charAt(j);
                     printwriter.print((char)k2);
                     j++;
                 }

                 while(j3 != 0)
                 {
                     byte byte1 = 97;
                     printwriter.print((char)byte1);
                     j3--;
                     j4++;
                 }
                 for(; j < s13.length() && j4 < 15; j++)
                 {
                     int i3 = 65 + s13.charAt(j);
                     printwriter.print((char)i3);
                 }

             }
             printwriter.println();
             break;

         default:
             System.err.println("Unsupported Pin Size");
             break;
         }
     } while(true);
     printwriter.close();
     fout.close();
 }

 private static final int pinNumberOffset = 0;
 static final int maxPinLength = 15;
 int splitNumberChars;
 ProcessingData pd;
 FileWriter fout;
}

