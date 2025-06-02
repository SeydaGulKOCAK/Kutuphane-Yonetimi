package com.mycompany.birinciprojem;
import java.util.ArrayList;
import java.util.Scanner;
class yeni{
  public ArrayList<String>kitapListesi; // Arraylist kullanıyoruz çünkü eğer böyle yaparsak dizi elemanları sayıısnda değişiklik yapabiliyoruz.
  public yeni()
  {
       kitapListesi = new ArrayList<>(); // yeni bir Array Listesi Oluşturuyoruz...
       //kitaplarımızı ekliyoruz.
      kitapListesi.add("Kayip Zamanin Izinde");
kitapListesi.add("Kirmizi Ve Siyah");
kitapListesi.add("Kurtlar Vadisi");
kitapListesi.add("Korkuyu Beklerken");
kitapListesi.add("Karakis");
kitapListesi.add("Kayip");
kitapListesi.add("Kucuk Prens");
kitapListesi.add("Karanlikta Kosanlar");
kitapListesi.add("Kanatsiz Kuslar");
kitapListesi.add("Kucuk Insanlar");
kitapListesi.add("Buyuk Dunya");
kitapListesi.add("Kondisyonel");
kitapListesi.add("Kelimeler Ve Yuzler");
kitapListesi.add("Kar");
kitapListesi.add("Kanatli Kardesler");
kitapListesi.add("Kilit");
kitapListesi.add("Kayip Ruhlar Kitabi");
kitapListesi.add("Kucuk Seyler");
kitapListesi.add("Kilavuz");
kitapListesi.add("Kafamda Bir Tuhaflik");
kitapListesi.add("Kayip Araniyor");


kitapListesi.add("Kayip Zamanin Izinde");
kitapListesi.add("Kucuk Prens");
kitapListesi.add("Kirmizi Ve Siyah");


kitapListesi.add("Savas Ve Baris");
kitapListesi.add("Suc Ve Ceza");
kitapListesi.add("Anna Karenina");
kitapListesi.add("Monte Kristo Kontu");
kitapListesi.add("Binbir Gece Masallari");

    }
  
  
  public void kitapEkle(String kitap)
  {
    
        kitapListesi.add(kitap);// add kullanarak ekleme yapabiliyoruz.
      System.out.println("Basari ile "+ kitap +" kutuphanemize eklendi.");
      
  }
  public void kitaplariListele()   // public kullanıyorum her yerden erişilebilsin diye
  {
      int k=1;
    for(String book :kitapListesi) // bu for - each döngüsü, kitapListesi ise book'lardan oluşan bir koleksiyon
  {
      System.out.println(k+"- " +book );// sıra sıra kitapları yazdırıyoruz.
      k++;
  }}
  public void kitapAra( String aranacakKitap)
  {
      int k=0;
   int sayim=kitapListesi.size();//kitaplistesinin boyutunu sayıma aktarıyoruz.
for(int h=0;h<sayim;h++)   
{
    if(kitapListesi.get(h).equals(aranacakKitap))// arrayListlerde dizilerdeki gibi [] yapamıyoruz .get() fonksiyonunu kullanmamız gerekiyor.
    {
        k++; // burada aranan kitaptan kaç tane olduğunaa bakıyoruz...
     }
    
}
if(k!=0)
      System.out.println("Aradiginiz "+ aranacakKitap +" adli kitaptan "+ k +" tane kutuphanemizde bulunmaktadir");     
else // eğer k = 0 ise
          System.out.println("MAALESEF...Aradiginiz kitap kutuphanemizde bulunmamaktadir.");

  }
  public void kitapSil(String silinecekKitap)
  {
   int h=0;
      for(int m=0;m<kitapListesi.size();m++)
      {
          if(kitapListesi.get(m).equals(silinecekKitap))// kitap listesindeki eleman silinecek kitap a eşit olduğunda
          { kitapListesi.remove(m); h++; m--; // burade arraylistlerde remove komutu ile dinamik bir şekilde silme işlemi yapabiliyoruz...
      }
  }
      System.out.println("Silmek istediginiz kitap: "+silinecekKitap +" idi. Toplam: "+h + " tane vardi \n BASARIYLA SILINDI...");
  

}}
public class Kutu {
    public static void main(String[] args) {
       
    System.out.println("Halk Kütüphanesine Hoşgeldiniz...\n********************");
    
   
    Scanner scanner=new  Scanner (System.in); //  dışarıdan girdi alabilmek için
yeni y1= new yeni();   //  yeni bir nesne üretiyoruz
while(true){
    System.out.println("Hangi islemi yapmak istiyorsunuz?\n Lutfen yapmak istediginiz islemin numarasini giriniz.\n 1- Yeni Kitap Ekleme \n 2- Kitaplari Listelemek \n"
            +" 3- Kitap aramak \n 4- Kitap Silme \n  5- Mevcut Kitap Kontrolu\n 6-Sistemden Cikis" );
    int secim=scanner.nextInt();
    scanner.nextLine(); // burada aslında boş dönen karakteri yakalıyoruz.
// alt kısımda da  kullanıcıdan veri alıyoruz ve daha sonra  doğru parametreleri vererek methodlarımıza iletiyoruz.
    if(secim==1)
    {
            System.out.println("Lutfen eklemek istediginiz kitabin ismini giriniz:");
            String eklenecekKitap=scanner.nextLine();
            y1.kitapEkle(eklenecekKitap);
    }
   else if(secim==2)
    {
        System.out.println("KITAPLARIN LISTESI \n ---------------");
         y1.kitaplariListele();
    }
  else  if(secim==3)
    {
        System.out.println("Hangi kitabi aramak istiyorsunuz?Lutfen kitabın ismini yazarken bas harfleri buyuk yazin...");
        String aranacakKitap=scanner.nextLine();
        y1.kitapAra(aranacakKitap);
        
       
    }
   else if(secim==4)
    {
        System.out.println("Silmek istediginiz kitabin ismini lutfen tum bas harfler buyuk olacak sekilde yazin.");
        String silinecekKitap=scanner.nextLine();
        y1.kitapSil( silinecekKitap);
       
       }
  
   
   else if(secim==5)
   {
       
            System.out.println("Hangi kitabin mevcut olup olmadigini kontrol etmek istersiniz?");
     String kontrolZamani=scanner.nextLine();
     y1.kitapAra(kontrolZamani);
       
   }
   
   else if(secim==6)
   {   System.out.println("Sistemden cikiliyor..."); break;
          //burada ise break kullanarak while döngüsünden çıkıyoruz.
    }
       }
         }

}
           



