package com.mycompany.birinciprojem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Uye { 
    private String ad;
    private String soyad;
    private int numara;
    private ArrayList<String> oduncGecmisi; //oduncGecmisi adında bir ArrayList Stringlerden oluşuyor.  
    
    public Uye(String ad, String soyad, int numara) { // Uye adında bir constructor
        this.ad = ad;
        this.soyad = soyad;
        this.numara = numara;
        this.oduncGecmisi = new ArrayList<>();  // ödünç geçmişini tutmak için yeni bir arraylist oluşturuyoruz.
    }

    public void setAd(String ad) { //set metodu oluşturuyoruz.
        this.ad = ad;
    }

    public void setSoyad(String soyad) { //set metodu oluşturuyoruz.
        this.soyad = soyad;
    }

    public void setNumara(int numara) { // set metodu
        this.numara = numara;
    }

    public int getNumara() { //get metodu
        return numara;
    }

    public String getAd() { // get metodu
        return ad;
    }
    public String getSoyad() { //get metodu
        return soyad;
    }
    public String yazdir() { // bilgileri yazdırmak için 
        return "  "+ad + "  " +soyad+ "  "  + numara;
    }
    public ArrayList<String> getOduncGecmisi() { //get metodu
        return oduncGecmisi;
    }
    public void kitapEkleOduncGecmisi(String kitapAdi) {
        oduncGecmisi.add(kitapAdi);
    }
    public String oduncGecmisiYazdir() {
        return oduncGecmisi.isEmpty() ? "Geçmiş boş!" : String.join(", ", oduncGecmisi);
        // eğer ödünç geçmişi boş ise "geçmiş boş " yazdır eğer değilse sıra sıra virgül koyarak ödünç geçmişini yazdır diyorum.
    }
}
class Kutuphane {
   
    public void kitapOduncAl(int uyeNumarasi, String kitapAdi, yeni y1) {
    boolean uyeBulundu = false;  // uyeyi bulmak için  kullandigimiz degisken

    for (Uye uye : uyeListesi) {
        if (uye.getNumara() == uyeNumarasi) {  // Üye numarasını kontrol ediyoruz.
            uyeBulundu = true;  // Üye bulundu

            uye.kitapEkleOduncGecmisi(kitapAdi);  //üyenin ödünç geçmişine kitap ekleniyor
            if (y1.kitapListesi.contains(kitapAdi)) {  // kitap listesi kitabı içeriyorsa
                y1.kitapListesi.remove(kitapAdi);  // Kitap listesinden belirtilen kitabı siliyoruz.
                System.out.println(uye.getAd() + " " + uye.getSoyad() + " adli kisiye " + kitapAdi + " adli kitap basariyla odunc verildi");
            } else {
                System.out.println("Maalesef " + kitapAdi + " kutuphanemizde bulunmamaktadir.");
            }
            return;  //döngüyü bitirmek iiçn
        }
    }

    if (!uyeBulundu) {  //eğer üye bulunmadıysa
        System.out.println("Uye bulunamadi, maalesef.");
    }
}
    Scanner scanner= new Scanner(System.in);
    
    
    private ArrayList<Uye> uyeListesi;
// Uyelerden oluşan uyeListesi adında bir ArrayList
    
    public Kutuphane() {                                                                                        
        uyeListesi = new ArrayList<>(); 
    }
    public void uyeEkle(Uye uye) {
        uyeListesi.add(uye);//bir üye ekliyoruz ve adını - soyadını - numarasını yazdırıyoruz...
        System.out.println(uye.getAd() + " " + uye.getSoyad() + " " + uye.getNumara() + " basarı ile sisteme yuklendi...");
    
    }
    public void uyeListele() {
        int k = 1;
        for (Uye uye : uyeListesi) { //foreach döngüsü sıra sıra uye bilgilerini yazdiriyoruz.
            System.out.println(k + ". uye" + uye.yazdir());
            k++;
        
        }}
    
    public void uyeAra(int uyeNumarasi) {
        for (Uye uye : uyeListesi) { //for-each döngüsünde eğer numara üye numarasına eşitse bulunan üyeyi döndürüyoruz.
            if (uye.getNumara() == uyeNumarasi) {
                System.out.println("Bulunan üye:\n" + uye.yazdir());
                return;
            }
        }
        System.out.println("MAALESEF.. ÜYE BULUNAMADI...");
    }
    public void oduncGecmisiGoruntule(int uyeNumarasi) {
        for (Uye uye : uyeListesi) {
            if (uye.getNumara() == uyeNumarasi) {// yine yukarıdaki gibi yine foreach döngüsü eğer girilen numara uyenumarasına eşitse uyenin odunc gecmisini yazdırıyoruz.
                System.out.println(uye.getAd() + " " + uye.getSoyad() + " adlı kişinin ödünç geçmişi: " + uye.oduncGecmisiYazdir());
                return;
            }
        }
        System.out.println("Üye bulunamadı!");}
public void uyeBilgileriGuncelle(int isbn)
{
    for(Uye uye: uyeListesi)
    {
        if(uye.getNumara()==isbn) // eğer girilen numara uyenin numarasına eşitse kullanıcının bilgileri görmesi için bilgileri yazdırıyoruz...
        { System.out.println("Sizin degistirmek istediginiz kullanicinin bilgileri: "+uye.getAd()+" "+uye.getSoyad()+ " "+ uye.getNumara());
       
        System.out.println("Peki hangi bilgiyi guncellemek istiyorsunuz? 1-isim\n 2-soyad\n 3- numara \n Degistirmek istediginiz bilginin numarasini giriniz:");
   int yapilanSecim=scanner.nextInt();
   scanner.nextLine();
   // guncellemesi icin kullanıcıya seceenekler sunuyoruz.
    switch(yapilanSecim)
    {
        case 1: System.out.println("Kullanicinin yeni ismini giriniz: ");
        String yeniIsim=scanner.nextLine();
        uye.setAd(yeniIsim); // güncelleme yapabilmek için set metodlarını çağırıyoruz.
        
        System.out.println("BASARILI GUNCELLEME \n Ismi basari ile guncellediniz.");break;
        case 2:System.out.println("Kullanicinin soyadini giriniz:");System.out.println("BASARILI GUNCELLEME \n Soyadi basari ile guncellediniz.");
        String yeniSoyad=scanner.nextLine();
        uye.setSoyad(yeniSoyad);break;
        case 3:System.out.println("Kullanicinin yeni numarasini(isbn) giriniz:");
        int yeniNumara=scanner.nextInt();
        
        uye.setNumara(yeniNumara);
            System.out.println("BASARILI GUNCELLEME \n basariyla numarayi guncellediniz.");
        break;
        default:System.out.println("Lutfen 1-3 arasinda bir sayi giriniz");   
     
    }
    }}
}
int h=0;

public void uyeSil(int silinecekUyeninNumarasi)
{
    boolean uyeBulundu=false;
    Iterator <Uye> iterator=uyeListesi.iterator(); // koleksiyonlar uzerinde güvenli bir şekilde gezinebilmek ve daha kontrollü çalışabilmek için iterator yapısını kullanıyoruz. eğer for-each kullansaydık eleman silmede hata alırdık.
    while(iterator.hasNext()) // sırada eleman varsa
    {
    Uye uye=iterator.next();
    if(uye.getNumara()==silinecekUyeninNumarasi) // eğer girilen numara uyenin gercekten numarasına esitse siliyoruz.
    {
        iterator.remove();
        System.out.println("Silme islemi basarili...");
        uyeBulundu=true;
        break;
    }}
    if(!uyeBulundu)
        System.out.println("Uyeyi bulamadik... Yanlis numara girisi...");
}
}







public class ikinciClassim {
    public static void main(String[]args)
    {

        Kutuphane k1= new Kutuphane();
    k1.uyeEkle(new Uye("Ahmet","Yildiz",51825));
         k1.uyeEkle(new Uye("Gokhan","Seher",6596));
    k1.uyeEkle(new Uye("Ali","Yildiz",7120));
    k1.uyeEkle(new Uye("Sena","yilmaz",1234));
    k1.uyeEkle(new Uye("Songul","Sahin",57859));
    k1.uyeEkle(new Uye("Mert","Besud",41255));
    k1.uyeEkle(new Uye("Kenan","Tok",56395));
    k1.uyeEkle(new Uye("Elfin","Ok",12055));

        int tamamMi=0;
        do{
        System.out.println("Lutfen yapmak istediginiz islemi seciniz.");
        System.out.println("1-Yeni uye ekle \n 2-Uyeleri Listele \n 3- Uye Arama \n4- Uye Bilgilerini Guncelleme\n"
                + "5- Uyelik Silme \n 6-Uyelerin Odunc Sistemini Goruntule \n 7- kitap odunc al \n 8-Cikis ");
        Scanner scanner=new Scanner(System.in);
        int sec=scanner.nextInt();
        scanner.nextLine();
      yeni y1=new yeni();
      
      
      
      
        if(sec==1)
        {
            System.out.println("Eklemek istediginiz kisinin ismini yazin");
            String isim=scanner.nextLine();
            System.out.println("Eklemek istediginiz kisinin soyadini yazin");
            String soyisim=scanner.nextLine();
             System.out.println("Eklemek istediginiz kisinin numarasini ISBN yazin");
           int number=scanner.nextInt();
          Uye yeniKatilimci= new Uye(isim,soyisim,number); // burada yeni üye ekliyoruz.
          // Uye bir sınıftır . buradaki yeniKatilimci ise değişkenin ismidir. new yeni bir şey oluşturduğumuzu belirtmek için. 
          // Uye(isim,soyisim,number) ise constructor olarak bir nesne oluşturulunca çalışan kısımdır. 
           k1.uyeEkle(yeniKatilimci);
        }
        
        else if(sec==2)
        {
           k1.uyeListele();
            
        }
        else if(sec==3)
        {
            System.out.println("Lutfen aramak istediginiz uyenin uye numarasini giriniz:");
             int uyeninNumarasi=scanner.nextInt();
             k1.uyeAra(uyeninNumarasi);
        }
        else if(sec==4)
        {
            System.out.println("Lutfen guncelleme yapmak istediginiz kisinin numarasini giriniz: ");
            int numaram= scanner.nextInt();
            scanner.nextLine();
            k1.uyeBilgileriGuncelle(numaram);
            
            
        }
        else if(sec==5)
        {
            System.out.println("Silmek istediginiz uyenin uye numarasini giriniz:");
            int silinecekNumara=scanner.nextInt();
          scanner.nextLine();
            k1.uyeSil(silinecekNumara);
            
        }
        else if(sec==6)
        {
            System.out.println("Odunc alma gecmisini gormek istediginiz kullanicinin isbn numarasini giriniz: ");
           int gecmisiGoruntule=scanner.nextInt();
          
          k1.oduncGecmisiGoruntule(gecmisiGoruntule);
        }
        else if(sec==7)
        {
            System.out.println("Lutfen odunc alacak kisinin numarayi giriniz: ");
             int oduncAlacakKisininNumarasi=scanner.nextInt();scanner.nextLine();
            System.out.println("Lutfen odunc almak istediginiz kitabi seciniz.");
           y1.kitaplariListele();
            System.out.println("Simdi hangi kitabi odunc almak istiyorsaniz lutfen bas harfleri buyuk olacak sekilde girin");
          String kitapIsmim= scanner.nextLine();
         
            k1.kitapOduncAl(oduncAlacakKisininNumarasi, kitapIsmim, y1);
        }
        else if(sec==8)
        {
            break;
        }
        
            System.out.println("Tekrar islemler yapmak istiyorsaniz 1 tusuna basin.\n Sistemden cikmak istiyorsaniz 0' -a basin...");
     tamamMi=scanner.nextInt();
            
    scanner.nextLine();
    if(tamamMi==0)
                System.out.println("Sistemden basari ile cikis yapiliyor...");
        }while(tamamMi==1);
    
    
    }
}
