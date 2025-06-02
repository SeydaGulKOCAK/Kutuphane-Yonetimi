package com.mycompany.birinciprojem;
import java.util.ArrayList;
import java.util.Scanner;


public class OduncAlimiVeIadeIslemi {
    public static void main(String[] args) {
       ArrayList<Kitap>kitapListesi= new ArrayList<>();// Kitapları tutan kitapListesi adında bir koleksiyon oluşturuyoruz.
       ArrayList<Uye> uyeListesi = new ArrayList<>();// Üyeleri tutan uyeListesi adında bir koleksiyon oluşturuyoruz.
       
   
kitapListesi.add(new Kitap("Kayip Zamanin Izinde"));// Arraylist kullandığımız için dinamik bir şekilde kitap ekleyebiliyoruz.
kitapListesi.add(new Kitap("Kirmizi Ve Siyah"));
kitapListesi.add(new Kitap("Kurtlar Vadisi"));
kitapListesi.add(new Kitap("Korkuyu Beklerken"));
kitapListesi.add(new Kitap("Karakis"));
kitapListesi.add(new Kitap("Kayip"));
kitapListesi.add(new Kitap("Kucuk Prens"));
kitapListesi.add(new Kitap("Karanlikta Kosanlar"));
kitapListesi.add(new Kitap("Kanatsiz Kuslar"));
kitapListesi.add(new Kitap("Kucuk Insanlar"));
kitapListesi.add(new Kitap("Buyuk Dunya"));
kitapListesi.add(new Kitap("Kondisyonel"));
kitapListesi.add(new Kitap("Kelimeler Ve Yuzler"));
kitapListesi.add(new Kitap("Kar"));
kitapListesi.add(new Kitap("Kanatli Kardesler"));
kitapListesi.add(new Kitap("Kilit"));
kitapListesi.add(new Kitap("Kayip Ruhlar Kitabi"));
kitapListesi.add(new Kitap("Kucuk Seyler"));
kitapListesi.add(new Kitap("Kilavuz"));
kitapListesi.add(new Kitap("Kafamda Bir Tuhaflik"));
kitapListesi.add(new Kitap("Kayip Araniyor"));

// Ayni kitaplardan birkaç tane daha ekliyoruz
kitapListesi.add(new Kitap("Kayip Zamanin Izinde"));
kitapListesi.add(new Kitap("Kucuk Prens"));
kitapListesi.add(new Kitap("Kirmizi Ve Siyah"));

// Fazladan birkaç kitap daha ekliyoruz
kitapListesi.add(new Kitap("Savas Ve Baris"));
kitapListesi.add(new Kitap("Suc Ve Ceza"));
kitapListesi.add(new Kitap("Anna Karenina"));
kitapListesi.add(new Kitap("Monte Kristo Kontu"));
kitapListesi.add(new Kitap("Binbir Gece Masallari"));// add fonksiyonu ile ekleyebiliyoruz.

  uyeListesi.add(new Uye("Ahmet","Yildiz",51825));
    uyeListesi.add     (new Uye("Gokhan","Seher",6596));
   uyeListesi.add (new Uye("Ali","Yildiz",7120));
   uyeListesi.add (new Uye("Sena","yilmaz",1234));
   uyeListesi.add (new Uye("Songul","Sahin",57859));
   uyeListesi.add (new Uye("Mert","Besud",41255));
   uyeListesi.add (new Uye("Kenan","Tok",56395));
   uyeListesi.add (new Uye("Elfin","Ok",12055));
         
     
        Scanner scanner= new Scanner(System.in);
    
    
    while(true) // kullanıcı çıkmak isteyene kadar döngü devam etsin diye.
    {
        System.out.println("\n1-Kitap odunc al");
        System.out.println("2-Kitap iade et");
        System.out.println("3-Kitap iade durumunu, musaitligini kontrol et");
        System.out.println("4-Cikis");
        System.out.println("Seciminiz: ");
        int secim=scanner.nextInt();
        scanner.nextLine();// boşluğu yakalamak için
        
        if(secim==1)
        {
            System.out.println("Uye numarasini girin: ");
            int uyeNumarasii=scanner.nextInt();
scanner.nextLine();


           
            System.out.println("Kitap adini giriniz:");
                    String kitapAdi=scanner.nextLine();
                          System.out.println("Tarih: (gg.aa.yyyy)");                 String tarih=scanner.nextLine();
                 kitapOduncAl(kitapListesi,uyeListesi,uyeNumarasii,kitapAdi,tarih);// kitap ödünç alabilmesi için bilgileri parametre olarak verip methoda gönderiyoruz.
}
else if(secim==2)
{
    System.out.println("Uye numarasini girin.");
int uyeNumarasi=scanner.nextInt();
scanner.nextLine();
    System.out.println("Kitap adini girin:");
String kitapAdi=scanner.nextLine();
kitapIadeEt(kitapListesi,uyeListesi,uyeNumarasi, kitapAdi);// kitap iade edilebilmesi için bilgileri parametre olarak verip methoda gönderiyoruz.
}
else if(secim==3)
{
    System.out.println("Iade durumunu kontrol etmek istediginiz kitabin ismini girin.");
    String kontrolEdilecekKitapIsmi=scanner.nextLine();
  
    Kitap.kitapMusaitliginiKontrolEt(kitapListesi, kontrolEdilecekKitapIsmi);//kitabın musait olup olmadığını öğrenmek için bilgileri parametre olarak verip, methoda iletiyoruz.
}


else if(secim==4)
{
    System.out.println("Cikis yapiliyor"); // kullanıcı isterse çıkabilsin döngü sonlansın diye break yazıyoruz.
break;

}
else{
            System.out.println("Gecersiz secim,tekrar deneyiniz...");

    }
    
    
    }

}
public static void kitapOduncAl(ArrayList<Kitap> kitapListesi, ArrayList <Uye>uyeListesi,int uyeNumarasi, String kitapAdi,String tarih)
{
Uye uye =uyeBul(uyeListesi, uyeNumarasi);
// burada Uye sınıfın adı 
//uye ise Uye sınıfından oluşturulacak nesnenin adıdır.
//uyeBul ise uyeListesi ve uyeNumarasi parametrelerine sahip olan bir metoddur.




if(uye== null) // uye boşsa
{
    System.out.println("Uye bulunamadi!!!");
return ;
}

Kitap kitap = kitapBul(kitapListesi, kitapAdi);
//Burada Kitap sınıfın adı 
//kitap ise Kitap sınıfından oluşturulacak nesnenin adıdır.
//kitapBul ise kitapListesi ve kitapAdi parametrelerine sahip olan bir metoddur.




if(kitap==null|| !kitap.isMusait()){ // kitap boşsa veya kitap yoksa
    System.out.println("Kitap musait degil ya da bulunamadi");
return ;
}

kitap.oduncVer(uye.getAd(),tarih); 
uye.kitapEkleOduncGecmisi(kitapAdi +" - "+ tarih);
    System.out.println(kitapAdi+ " basari ile odunc verildi");

}
//kitap iade etme islemi
public static void kitapIadeEt(ArrayList<Kitap> kitapListesi,ArrayList <Uye> uyeListesi,int uyeNumarasi,String kitapAdi)
{
    //üyeyi üye numarasına göre bulma.
   Uye uye = uyeBul(uyeListesi, uyeNumarasi);
   //üye bulunmazsa hata mesajı verilr
if(uye==null)
{
    System.out.println("Uye bulunamadi");
return ; //fonksiyondan çıkmak için
}
//kitabı kitap listesinnden adıyla bulma
Kitap kitap=kitapBul(kitapListesi,kitapAdi);
if(kitap==null||kitap.isMusait())// kitap boşsa veya kitap müsait değilse 
{
    System.out.println("Kitap zaten iade edilmis ya da bulunamadi");
return; //fonksiyondan çık
}
kitap.iadeEt(); //kitap iade edilir.
boolean silindi=false;
for(String gecmis: uye.getOduncGecmisi())
{
if(gecmis.contains(kitapAdi)) // eger gecmiş kitapAdini içeriyorsa
{
uye.getOduncGecmisi().remove(gecmis); // bu kitabı uyenin geçmişinden sil.
silindi=true;
break;// döngüden çık
}
}
//kitap geçmişten başarıyla silindiyse başarılı mesajı verilir.
if(silindi)
{
    System.out.println(kitapAdi+" basari ile iade edildi.");

}
else{
    System.out.println("Hata: Kitap gecmiste bulunamadi ancak iade edildi");
}
}
public static Kitap kitapBul(ArrayList <Kitap> kitapListesi,String kitapAdi)
{
for(Kitap kitap : kitapListesi)
{
  if(kitap.getAd().equalsIgnoreCase(kitapAdi)) //küçük büyük harflere karşı duyarsız yapıyoruz.
{
return kitap;// kitap bulunduysa kitap döndürülür.
}
}
return null;// kitap bulunmazsa null döndürülür.
}
//üye listesinden belirtilen numara ile üye bulma
public static Uye uyeBul(ArrayList <Uye> uyeListesi,int uyeNumarasi){

for(Uye uye : uyeListesi)
{
    //üye numarası eşleşirse üye döndürülür.
if(uye.getNumara()==uyeNumarasi)
{
return uye; 
}
}
return null; //üye bulunmazsa null döndürülür.
}


static class Kitap{
private String ad;        //kitabın adı
private boolean musait;  //kitabın mevcut olup olmadığını belirten durum
private String oduncAlan; // kitabı ödünç alan kişinin adı
private String oduncTarihi; //kitabın ödünç verildiği tarih
//yapıcı method : kitap adı verilir ve kitap başlangıçta müsait (mevcut) olarak ayarlanır. 
public Kitap(String ad)
{
this.ad=ad;
this.musait=true;   // başlangıçta kitap mevcut durumda
}

//kitabın adını geri döndüren metod
public String getAd(){
return ad;
}

//kitabın musait olup olmadığını kontrol eden metod
public boolean isMusait()
{
return musait;
}
//kitaba odunc verme işlemi
public void oduncVer(String oduncAlan,String tarih)
{
this.musait=false; //kitap artık mevcut değil.(ödünç verilmiş.)
this.oduncAlan=oduncAlan; //kitabı ödünç alan kişi 
this.oduncTarihi=tarih; //ödünç verme tarihi

}
//kitabın ödünç verildiği tarihi döndüren metod
public String getOduncTarihi()
{
return oduncTarihi;
}



// kitap iade edildikten sonra durumu güncelleyen metot
public void iadeEt()
{
    
    this.musait=true; // kitap tekrar mevcut
    this.oduncAlan = null; // ödünç alan kişi bilgisi sıfırlanır.
    this.oduncTarihi = null;// ödünç verme tarihi sıfırlanır.
}

//kitap listesinde belirli bir kitabın musaitlik durumunu kontrol etme
public static void kitapMusaitliginiKontrolEt(ArrayList<Kitap> kitapListesi,String kitapAdi)
{
    Kitap kitap= kitapBul(kitapListesi,kitapAdi);//belirtilen kitaba göre kitap bulma
    if(kitap==null)
    {
        System.out.println("kitap bulunamadi");//kitap bulamazsa mesaj
    }
    else if(kitap.isMusait())
    {
        System.out.println("Kitap musait.");//kitap mevcutsa mesaj
    }    
    else{
        System.out.println("Kitap su anda odunc verilmis");
    }
}
}
//uye sınıfı , kullanıcıları (üyeleri) temsil eder.
static class Uye{
private int numara;
private String ad;
private String soyad;
private ArrayList <String> oduncGecmisi;
//Yapıcı metod : üye bilgileri(ad,soyad,numara) ile üye oluşturulur.
public Uye( String ad,String soyad,int numara)
{
this.numara=numara;
this.ad=ad;
this.soyad=soyad;
this.oduncGecmisi=new ArrayList<>();// ödünç geçmişi başta boş
}
//üyenin numarasını döndüren metod
public int getNumara()
{
return numara;
}
//üyenin adını döndüren metod
public String getAd(){
return ad;
}

//üyenin ödünç geçmişine bir kitap ve tarihi ekleyen metot
public void kitapEkleOduncGecmisi(String kitapVeTarih)
{
oduncGecmisi.add(kitapVeTarih);//kitap adı ve tarih bilgisi geçmişe eklenir
}
//üyenin ödünç geçmişini döndüren metot
public ArrayList <String> getOduncGecmisi(){
return oduncGecmisi;
}}
}