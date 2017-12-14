package com.jangle.mongotest_snr.mongotest_snr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.jangle.mongotest_snr.mongotest_snr.api.jangle.Jangle;
import com.jangle.mongotest_snr.mongotest_snr.api.jangle.JangleRepository;
import com.jangle.mongotest_snr.mongotest_snr.api.user.User;
import com.jangle.mongotest_snr.mongotest_snr.api.user.UserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MongotestSnrApplication {

	private String[] followers = new String[1000];

	public static void main(String[] args) {
		SpringApplication.run(MongotestSnrApplication.class, args);

	}

	@Bean
	public CommandLineRunner init(UserRepository userRepository, JangleRepository jangleRepository) {
		Random r = new Random();
		String parcalanacak = "Cumhuriyetin ilk yıllarında ölen bazı sanatçılar dışında Milli Edebiyatçılar Beş Hececiler ve Bağımsızlar olarak ele aldığımız şair ve yazarlar sanat hayatlarına Cumhuriyet dönemi Türk edebiyatında da devam etmişlerdir 1923ten 1940a kadar devam eden dönemde Kurtuluş Savaşının yarattığı birliğin yapılan inkilaplar ve reformların etkisiyle sanatçılar \"memleket edebiyatı\" anlayışıyla Anadoluya yönelir Özellikle 1930lu ve 1940lı yıllarda yeni akımlar ve topluluklar oluşmuştur Yedi Meşaleciler Birinci Yeniciler (Garipçiler) Maviciler İkinci Yeniciler Toplumsal Gerçekçiler Cumhuriyet dönemi eselerlerinde öz Türkçecilik anlayışının da etkisiyle genel olarak açık ve anlaşılır bir dil kullanılmıştır Anadolu doğal güzellikleri insanı sosyal hayatı ve folkloruyla edebi eserlere yansımış Türk tarihi ve Atatürkle ilgili konular ağırlık kazanmış 1940lı yıllardan sonra ise bireysel duygu ve sorunlar da ele alınmıştır Dünyaya açılma ve çağdaşlaşma çabaları edebiyatı da etkilemiş Dünya edebiyatı daha yakından takip edilmiştir Dünya edebiyatıyla kurulan bağlar sonucunda toplumsal gerçekçilik varoluşçuluk dışavurumculuk gerçeküstücülük gelecekçilik gibi akımların etkisinde ürünler verilmiştir İlk yıllarda genellikle Halk edebiyatı nazım şekilleri ve hece ölçüsü kullanılmış 1940lı yıllardan sonra ise serbest şiir yaygınlaşmış aruzu sürdürenler oldukça azalmıştır Roman ve hikayelerde toplumsal ve kültürel farklılıklar ülke ve toplum sorunları Kurtuluş Savaşı eskiyeni çatışması köy ve kasaba insanın çelişkileri tarihi konular yanlış Batılılaşma konuları ağırlıkla işlenmiştir Tiyatro yeni Cumhuriyetin ilkelerini halka aktarmada bir araç olarak hızla yaygınlaşmaya başlamıştır çocuk tiyatrosu çalışmaları yapılmış kadınlar sahnede daha çok yer almaya başlamış Devlet Konservatuarı açılmıştır Deneme eleştiri edebiyat tarihi alanlarında Cumhuriyet döneminde büyük ilerlemeler kaydedilir önemli eserler verilir CUMHURİYET DÖNEMİ TÜRK EDEBİYATINDA TOPLULUKLAR  YEDİ MEŞALECİLER  Kenan Hulisi Koray (Öykücü) Cevdet Kudret Solok Muammer Lütfi Bahşi Sabri Esat Siyavuşgil Yaşar Nabi Nayır Vasfi Mahir Kocatürk Ziya Osman Saba 1928de \"Yedi Meşale\" adlı ortak bir kitap yayımlayan biri öykücü altısı şair yedi kişinin oluşturduğu bir topluluktur Sanat için sanat anlayışını savunmuşlar samimiyeti ve içtenliği öne çıkaran bir sanat istemişlerdir Beş Hececilerin sürdürdüğü memleketçi edebiyat anlayışına tepki duymuşlar sanatta Batılı ilkelerin savunucusu olmuşlardır Hece ölçüsüyle özellikle Fransız sembolistlerini örnek alarak şiirler yazmışlardır Yedi Meşaleciler de Fecri Aticiler gibi etkin olamamışlar \"Meşale\" adlı dergiyi sekiz sayı yayımladıktan sonra dağılmışlardır BİRİNCİ YENİ (Garipçiler)  Orhan Veli Kanık Melih Cevdet Anday Oktay Rıfat Harozcu Akım üç şairin 1941de ortak yayımladıkları Garip adlı şiir kitabıyla başlamıştır Şiir ve edebiyat hakkındaki düşüncelerini kitabın girişinde Orhan Veli tarafından (imzası olmamakla birlikte) yazıldığı düşünülen Garip Bildirgesi ile ortaya koymuşlardır Sürrealizmden etkilendikleri yönler vardır Şiirimizde en köklü değişimleri yapmışlardır Şiirde ölçü ve uyağı gereksiz görmüşler serbest şiir örnekleri vermişlerdir Süslü ve sanatlı şiire şairaneliğe tepki göstermişlerdir Sokaktaki insanın halkın konuştuğu dille şiirler yazdılar Şiirde espriyi nükteyi kullandılar ve şaşırtmaya dayalı şiirler yazdılar Günlük hayattaki her konunun şiirde yer alması gerektiğini savundular Şiiri duygudan çok akla yakın bir sanat olarak gördüler Toplumsal aksaklıkları şiirin doğal akışını bozmadan ve bir mesaj iletme kaygısı duymadan yansıttılar 1950de Orhan Velinin ölümüyle akımın diğer sanatçıları Oktay Rıfat ve Melih Cevdet zamanla farklı şiirlere yöneldiler İKİNCİ YENİ  Cemal Süreya İlhan Berk Edip Cansever Ece Ayhan Turgut Uyar Sezai Karakoç 1950den sonra Garip akımını takip eden gençlerin özentili kötü örneklerinin hakim olduğu bir ortamda Garipe karşı doğmuş bir harekettir 195Olerin başlarında \"Yeditepe\" ve \"Pazar Postası\" gibi dergilerde birbirinden habersizce şiir yayımlayan şairler arasında görülen ortaklık İkinci Yeni adını almıştır Oktay Rıfat Perçemli Sokak kitabıyla İkinci Yeni hareketine uygun şiirler yazmıştır İmgeli sanatlı bir şiir dilinden yana olmuşlardır Anlamın kapalı olduğu soyut bir şiiri savunmuşlardır Sürrealizm Dada gibi akımlardan etkilenmişlerdir Günlük konuşma dilinden farklı bir şiir diliyle yazmışlardır Sözcük ve cümle yapısının bozulduğu yeni sözcüklerin türetildiği şiirleri vardır Ahlaki değerleri folkloru şiirde bir hikaye anlatmayı konuyu dışlamışlardır MAVİCİLER  Attilla İlhan Ferit Edgü Demir Özlü Orhan Duru 1952de Ankara da yayımlanmaya başlayan \"Mavi\" adlı dergi etrafında toplanan yazarların oluşturduğu bir topluluktur Garipe karşı duran toplumcu edebiyat anlayışına yakın düşünceleri olan bir topluluktur TOPLUMSAL GERÇEKÇİLER  Nazım Hikmet Sabahattin Ali Kemal Tahir Orhan Kemal Yaşar Kemal Aziz Nesin Sosyalist bir dünya görüşüne uygun olarak toplumcu eserler yazmış sanatçıların oluşturduğu bir edebiyattır Topluluğun Türk edebiyatında tanınmasında ve yaygınlaşmasında Nazım Hikmetin büyük bir etkisi vardır Topluluk üyeleri edebiyatın hemen hemen bütün türlerinde toplumu bilinçlendirme amacıyla eserler yazmışlardır Serbest şiiri Garipçilerden de önce kullanan Toplumsal Gerçekçiler roman ve hikayelerde de yalın bir dille daha çok köylü ve işçi sorunlarını ele almışlardır HİSARCILAR  Munis Faik Ozansoy İlhan Geçer Mehmet Çınarlı Gültekin Samanoğlu Mustafa Necati Karaer Turgut Özakman Yavuz Bülent Bakiler Bekir Sıtkı Erdoğan 1950lerde Hisar dergisi etrafında toplanan sanatçıların oluşturduğu topluluktur Garipçilere tepki göstermişler ve milli duyguları manevi değerleri öne çıkaran bir edebiyattan yana olmuşlardır Ölçü uyak gibi klasik edebiyat öğelerini kullanarak aşk doğa ve vatan sevgisi gibi konuları işlemişlerdir CUMHURİYET DÖNEMİ TÜRK EDEBİYATINDA ÖNEMLİ SANATÇILAR  ABDÜLHAK ŞİNASİ HİSAR (18831963)  İstanbulun lüks semtlerini ve Boğaziçinı eski aşklarını eğlencelerini anlatmıştır Anlaşılır bir dille anı makale öykü ve romanlar yazmıştır Anıları ve CHP roman yarışmasında (1942) üçüncü olan Fehim Bey ve Biz adlı romanı önemli eserleridir ESERLERİ Anı Boğaziçi Mehtapları Boğaziçi Yalıları Geçmiş Zaman Köşkleri İstanbul ve Pier Loti Roman Fehim Bey ve Biz MİTHAT CEMAL KUNTAY(18851956)  Milli edebiyatçıların dil anlayışlarına uygun olarak hem heceyle hem de aruzla epik şiirler yazmıştır Şiirleri dışında önemli eseri Üç İstanbul adlı romanıdır ESERLERİ Şiir Türkün Şehnamesi Roman Uç İstanbul KEMALETTİN KAMU (19011948)  Vatan sevgisini aşk gurbet ve doğa sevgisini işlediği şiirleriyle tanınır \"Bingöl Çobanları\" adlı pastoral şiıri oldukça ünlüdür ESERLERİ Şiir Gurbet Bingöl Çobanları BEHÇET KEMAL ÇAĞLAR (19081969)  Halk şiiri biçim özellikleriyle şiirler yazmıştır Atatürke ve cumhuriyete olan sevgisini anlatmıştır \"Ankaralı Aşık Ömer\" takma adıyla şiirler de yazmıştır ESERLERİ Şiir Erciyesten Kopan Çığ Burada Bir Kalp Çarpıyor Benden İçeri ÖMER BEDRETTİN UŞAKLI (19041946)  Hece ölçüsüyle şiirler yazmıştır Anadoluyu tarihi deniz güzelliklerini işlemiştir ESERLERİ Şiir Deniz Sarhoşları Yayla Dumanı Sarıkız Mermerleri AHMET HAMDİ TANPINAR (1901  1962)  Şiir öykü roman edebiyat tarihi makale deneme alanlarında eserler vermiştir Eserlerinde DoğuBatı çatışması \"rüya\" ve \"zaman\" kavramları \"geçmişe özlem\" \"mimari\" ve \"musiki\" öne çıkar \"Ne içindeyim zamanın! Ne de büsbütün dışında\" dizeleri onun zamanı kavrayışının özünü vermektedir Bursada Zaman şiiri geniş bir kesim tarafından sevilmiştir Ahmet Haşimin özellikle de Yahya Kemalin etkisinde kalmış sembolizmden etkilenmiştir Romanlarında psikolojik tahlillere önemle eğilen yazarın kendine has bir üslubu vardır Yazarlığı dışında İstanbul Üniversitesinde edebiyat profesörlüğü milletvekilliği de yapmıştır \"Beş Şehir\" adlı önemli deneme kitabında Ankara Erzurum Bursa Konya ve İstanbulu anlatmıştır \"Huzur\" romanı aşkı psikolojiyi ve Doğu  Batı karşıtlığını içerir roman kişilerinin adlarının verildiği dört bölümden oluşur  İhsan Nuran Suat ve Mümtaz ESERLERİ Şiir Bütün Şiirleri Romanları Mahur Beste Saatleri Ayarlama Enstitüsü Huzur Sahnenin Dışındakiler Aynadaki Kadın Öykü Abdullah Efendinin Rüyaları Yaz Yağmuru Deneme Beş Şehir Yaşadığım Gibi Makale inceleme Yahya Kemal XIX Asır Türk Edebiyatı Tarihi Edebiyat Üzerine Makaleler AHMET MUHiP DRANAS (1908 1980)  Şiirleriyle tanınmakla birlikte tiyatro eserleri de vardır Fransız sembolizmiyle Türk şiir geleneğini başarıyla kaynaştırmıştır Hece ölçüsüyle biçimsel mükemmelliğe önem verdiği şiirler yazmıştır Aşk insanın iç dünyası gibi bireysel duyguları işlemiştir Kar Olvido Ağrı ve Fahriye Abla şiirleriyle sevilmiştır ESERLERİ Şiir Şiirler Oyun Gölgeler 0 Böyle İstemezdi NECİP FAZIL KISAKÜREK (1905  1983)  Şiirleri ve tiyatrolarıyla ün kazanmış usta bir yazardır Büyük Doğu ve Ağaç dergilerini çıkarmıştır Fransız sembolistlerinden ve halk şiirinden yararlanarak heceyle kendine has başarılı şiirler yazmıştır İlk dönem şiirlerinden sonra mistik konuları madde ve ruh ilişkisini insanın evrendeki yerini konu edinen şiirler yazmıştır \"Kaldırımlar\" şiiriyle geniş bir kesim tarafından tanınmış ve sevilmiştir Şiirlerini Çile başlığı altında bir kitapta toplamış ve bu kitapta şiir anlayışını düzyazı olarak anlatmıştır ESERLERİ Şiir Örümcek Ağı Kaldırımlar Ben ve Ötesi Sonsuzluk Kervanı Çile Oyun Tohum Bir Adam Yaratmak Künye Sabırtaşı Para Namı Diğer Parmaksız Salih Reis Bey Yunus Emre Abdülhamit Han Ahşap Konak Öykü Hikayelerim Roman Aynadaki Yalan Anı Yılanlı Kuyudan ARİF NİHAT ASYA (1904  1975)  \"Bayrak Şairi\" olarak bilinir Hece ve aruzu kullandığı şiirlerin yanı sıra serbest şiirler de yazmıştır Dini ve milli duyguları kahramanlıkları sade bir dille şiirleştirmiştir Rubai türünün son ustalarındandır ESERLERİ Şiir Bir Bayrak Rüzgar Bekliyor Kıbrıs Rubaileri Köprü Mensur Şiir Yastığımın Rüyası Ayetler Düzyazı Kanatlar ve Gagalar Terazi Kendini Tartmaz TARIK BUĞRA (1918 1994)  Öykü roman deneme ve tiyatrolarıyla tanınır Öykü ve romanlarında Türk toplumunun tarihine yönelmiştir Psikolojik öğelere yer vermiştir Kurtuluş Savaşı yıllarını anlattığı Küçük Ağa ve Osmanlı devletinin kuruluşunu anlattığı \"Osmancık\" romanlarıyla tanınır ESERLERİ Roman Küçük Ağa Küçük Ağa Ankarada Osmancık Firavun İmanı Ibişin Rüyası Öykü Yarın Diye Bir Şey Yoktur Siyah Kehribar Oğlumuz ZİYA OSMAN SABA (1910 1957)  Yedi Meşaleciler içinde şiiri uzun soluklu olarak sürdüren tek kişidir Hece ölçüsüyle yazdığı şiirlerin yanında serbest şiirleri de vardır Şiirlerinde çocukluğa özlem anılar ev ve aile sevgisi konuları öne çıkar Öykülerinde de ağırlıklı olarak anılarından hareket etmiştir ESERLERİ Şiir Sebil ve Güvercinler Öykü Mesut İnsanlar Fotoğrafhanesi Değişen İstanbul YAŞAR NABİ NAYIR (1908 1981)  Yedi Meşalecilerdendir Şiirleri dışında değişik türlerde eserler de vermiştir Varlık dergisinin kurucusu olması bakımından önem taşımaktadır ESERLERİ Şiir Kahramanlar Onar Mısra CEVDET KUDRET SOLOK (19071992)  Yedi Meşalecilerdendir Şiirde ısrarcı olamayan yazar edebiyat araştırmalarına yönelmiştir ESERLERİ DenemeEleştiri Dilleri Var Bizim Dile Benzemez Araştırma  inceleme Türk Edebiyatında Hikaye ve Roman Örneklerle Edebiyat Bilgileri ORHAN VELİ KANIK (1914 1950)  Garip Akımının öncüsüdür Şiiriyle eski şiir geleneğini yıkmış bir şairdir Şiirde klişelere şairaneliğe benzetmelere ölçüye uyağa vb karşı çıkmıştır Sokaktaki sade vatandaşı onların dilini kullanarak anlatmıştır Garip dönemi öncesinde klasik şiirler yazmış olan şair ömrünün son yıllarında şiirlerinde halk şiirinden yararlanmıştır Kitabei Sengi Mezar Anlatamıyorum Hürriyete Doğru Istanbulu Dinliyorum vb şiirleriyle tanınmış ve sevilmiştir Garip ön sözünü de o kaleme almıştır Sürrealizmden etkilenmiştir ESERLERİ Şiir Garip Vazgeçemediğim Destan Gibi Yenisi Karşı  Çocuk şiirleri Nasreddin Hoca Hikayeleri La Fontaine den Masallar (çeviri) MELİH CEVDET ANDAY (1916  2002)  Garip akımının öncülerindendir Şiirin dışında roman oyun deneme gezi türlerinde önemli eserler vermiştir Garip tarzı şiirlerinin ardından \"zaman\" sorunu etrafında mitolojiden ve tarihten beslenen bir şiire yönelmiştir ESERLERİ Şiir Garip Rahatı Kaçan Ağaç Telgrafhane Kolları Bağlı Odysseus Oyun Mikadonun Çöpleri OKTAY RİFAT HOROZCU (1914 1988)  Garip akımının öncülerindendir Garip döneminden sonra Perçemli Sokak kitabıyla Il Yeni tarzı şiirler yazmıştır Folklordan yararlandığı toplumcu çizgiye yakın durduğu eserler de ortaya koymuştur ESERLERİ Şiir Garip Perçemli Sokak Karga ile Tilki Aşık Merdiveni KEMALTAHİR (19101973)  Toplumcu gerçekçi bir romancıdır Cezaevi yaşamını Kurtuluş Savaşını tarihi köy yaşamını ve eşkıya hikayelerini konu edindiği romanlarıyla tanınmıştır Tasvire önem veren yazar eserlerinde anlaşılır bir dil ve yalın bir anlatım kullanmıştır Osmanlının kuruluşunu anlattığı Osmanlı toplumunun gelişim sürecinin Batıdan farklı olduğunu ileri sürdüğü tezli romanı \"Devlet Ana\" romanıyla ve Kurtuluş Savaşı yıllarını konu edindiği \"Yorgun Savaşçı\" romanlarıyla tanınmıştır ESERLERİ Roman Devlet Ana Yorgun Savaşçı Esir Şehrin İnsanları Rahmet Yolları Kesti Esir Şehrin Mahpusu Bozkırdaki Çekirdek Kurt Kanunu AZİZ NESİN (1916 1995)  Toplumcu gerçekçi bir yazardır Dünyaca tanınmış mizahi öykü yazarıdır ESERLERİ Roman Yaşar Ne Yaşar Ne Yaşamaz Öykü Toros Canavarı Damda Deli Var Fil Hamdi Sizin Memlekette Eşek Yok Mu? ORHAN KEMAL (1914 1973)  Toplumcu gerçekçi bir yazardır Gerçek adı \"Mehmet Raşit Oğütçü\" olan yazar daha çok öyküleriyle tanınır Öyküleri dışında oyun roman ve film senaryoları da yazmıştır Öykü ve roman kişilerini konuşturmadaki ustalığı dikkat çekmiştir Çukurovanın sanayileşmesini ve işçi sorunlarını tarımın makineleşmesi ve ırgatların sıkıntılarını mahpusları bekçileri gardiyanları konu edinmiştir ESERLERİ Öykü Ekmek Kavgası 72 Koğuş Önce Ekmek Mahalle Kavgası Roman Baba Evi Murtaza Cemile Bereketli Topraklar Üzerinde Hanımın Çiftliği Avare Yıllar Gurbet Kuşları YAŞAR KEMAL (19222015)  Toplumcu gerçekçi bir yazardır Gerçek adı Kemal Sadık Göğçelidır Adını ilk olarak Cumhuriyet gazetesindeki röportajlarıyla duyurmuştur İlk romanı İnce Memedle büyük ün kazanmış ve romancı kimliği öne çıkar olmuştur Türk edebiyatının olduğu kadar dünya edebiyatının da önemli romancılarındandır Çukurovayı insanıyla sorunlarıyla doğasıyla destansı bir dille anlatmıştır Romanlarında doğayı ustaca ve ayrıntılı olarak betimlemiştir Masallardan ağıtlardan halk hikayelerinden efsanelerden ustaca yararlanmayı bilmiştir ESERLERİ Roman İnce Memed Yer Demir Gök Bakır Demirciler Çarşısı Cinayeti Orta Direk Teneke Yılanı Öldürseler Yusufçuk Yusuf Öykü Sarı Sıcak Röportaj Bu Diyar Baştan Başa Derleme (Özgün Anlatı) Üç Anadolu Efsanesi BEHÇET NECATİGİL (19161979)  Cumhuriyet dönemi Türk şiirinde kendi çizgisini yaratmış şairlerdendir Heceyi kullandığı şiirleri olmakla birlikte ağırlıklı olarak serbest şiirler yazmıştır Şiir geleneğinden ustaca esinlenmeyi bilen söyleyişi rahat samımı bir şiiri vardır Büyük kentte yaşayan orta tabaka insanının yaşantısını bunalımlarını evaile sorunlarını geçim sıkıntısını işlemiştir Şiirleri kadar radyo oyunları da önemlidir ESERLERİ Şiir Kapalıçarşı Evler Divançe Arada Çevre Eski Toprak Radyo Oyunu Yıldızlara Bakmak Uç Turunçlar Araştırmabiyografi Edebiyatımızda İsimler Sözlüğü Araştırma Edebiyatımızda Eserler Sözlüğü CAHİT SITKI TARANCI (1910 1956)  Otuz Beş Yaş Desem ki ve Gün Eksilmesin Penceremden şiirleriyle tanınır Şiirlerinin çoğunda ölüm konusunu işlemiştir Romantizm ve sembolizmden etkilenmiştir Hece ölçüsüyle yazdığı şiirleri de serbest şiirleri de vardır Şiirde biçime kafiyeye ve ahenge önem vermiştir ESERLERİ Şiir Otuz Beş Yaş Düşten Güzel Ömrümde Sükut Sonrası Mektup Ziyaya Mektuplar AHMET KUTSİ TECER (1901  1967)  \"Neredesin?\" şiiriyle tanınmış ve sevilmiştir Şair ve oyun yazarıdır Halk şiiri geleneğine bağlı bir şairidir Aşık Veyseli edebiyat dünyamıza o tanıtmıştır ESERLERİ Şiir Şiirler Oyunları Koçyiğit Köroğlu Köşebaşı SABAHATTİN EYÜBOĞLU (1908 1973)  Deneme ustalarındadır Araştırma ve incelemeleri de vardır ESERLERİ Deneme Mavi ve Kara Sanat Üzerine Denemeler CAHİT KULEBİ (1917 1997)  \"Hikaye\" şiiriyle tanınmış ve sevilmiştir Aşık edebiyatı geleneğinden beslendiği ve Anadoluyu anlattığı kendine has bir şiir çizgisi vardır Serbest şiirler yazmıştır Yurt ve doğa sevgisi aşk Kurtuluş Savaşı yalnızlık başlıca konularıdır ESERLERİ Şiir Atatürk Kurtuluş Savaşında Yeşeren Otlar Türk Mavisi FAZIL HÜSNÜ DAĞLARCA (19142008)  Şiire hece ölçüsüyle başladı serbest şiire geçti Çocuk ve Allah kitabıyla ün kazandı Biçim içerik ve söyleyişte sağladığı uyumla dikkat çekti Hayal gücünü öne çıkardığı imgeli ilk şiirlerinden sonra aklı öne çıkardığı şiirler yazmıştır Kırkı aşkın eseriyle Türk şiirinin en verimli şairidir Tür biçim ve içerik bakımından kendini sürekli yenilemiş kendine özgü bir şiir dili yaratmıştır Hemen hemen her konuda şiir yazmıştır Yerliyabancı hiçbir akımdan etkilenmeden klasiği ve çağdaşı kaynaştırdığı özgün bir şair olmuştur \"Türkçem benim ses bayrağım\" dizesiyle Türkçeye olan sevgisini anlatmıştır Destan tarzında şiirler de felsefi link toplumcu şiirler de yazmıştır ESERLERİ Şiir Havaya Çizilen Dünya Çocuk ve Allah Üç Şehitler Destanı Gazi Mustafa Kemal Atatürk İstiklal Savaşı Sivaslı Karınca İstanbul Fetih Destanı Anıtkabir Mevlanada Olmak Tük Olmak Çanakkale Destanı Vietnam Savaşımız Hiroşima Nötron Bombası Malazgirt Ululaması Yazıları Seven Ayı (Çocuk Şiirleri) Yunus Emrede Olmak MEMDUH ŞEVKET ESENDAL (1883 1952)  Durum  kesit (Çehov Tarzı) öykücülüğünün ilk ustasıdır Halkın içinden kişileri (memur esnaf) onların önemsiz görünen davranışlarını konu edinmiştir Halkı iyi ve kötü yönleriyle onları sevdirerek anlatmıştır Sade süssüz kısa cümlelerle kurulmuş yumuşak bir dili vardır Toplumun çektiği sıkıntıları sorunları abartmadan ve umutsuzluğa düşürmeden göz önüne sermiştir Haşmet Gülkokan ve Komiser hikayeleriyle sevilmiştir ESERLERİ Hikaye Otlakçı Mendil Altında Temiz Sevgiler Ev Ona Yakıştı Roman Ayaşlı ve Kiracıları Miras SAİT FAİK ABASIYANIK (1906 1954)  Çağdaş öykücülüğün öncülerindendir Hikayelerinde \"konu\" ve \"olaydan çok \"zamandan ve \"insan yaşamı\"ndan kesitler öne çıkar Maupassant tarzından çok Çehov tarzı hikayeye yakındır Genellikle gerçekçi olan yazarın bazı öykülerinde gerçeküstücü öğeler öne çıkar İstanbul deniz balık yoksulluk avare insanlar doğa yaşama bağlılığın göstergesi olarak öykülerinde sıkça yer bulur Hikayelerini sade bir Türkçeyle yazmıştır ESERLERİ Öykü Semaver Sarnıç Mahalle Kahvesi Tüneİdeki Çocuk Şahmerdan Lüzumsuz Adam Havada Bulut Kumpanya Alemdağda Var Bir Yılan Son Kuşlar Az Şekerli Romanları Medarı Maişet Motoru (Sonraki baskıda adı \"Birtakım İnsanlar\") Kayıp Aranıyor Şiir Şimdi Sevişme Vakti Röportaj Mahkeme Kapısı HALİKARNAS BALIKÇISI (18861973)  Asıl adı Cevat Şakir Kabaağaçlıdır Eserlerinde denizi deniz insanlarını Bodrumu Ege denizinin efsanelerini anlatmıştır Üslüba ve tekniğe çok önem vermeyen yazarın şiirsel destanımsı ve coşkulu bir anlatımı vardır Eski Yunan ve Anadolu uygarlıkları ve mitoloji birikimini de eserlerinde yansıtmıştır ESERLERİ Öykü Merhaba Akdeniz Ege Kıyılarından Yaşasın Deniz Egenin Dibi Gülen Ada Gençlik Denizlerinde Roman Aganta Burina Burinata Ötelerin Çocuğu Uluç Reis Turgut Reis Deniz Gurbetçileri Anı Mavi Sürgün HALDUN TANER (19161986)  Öykü ve oyun yazarıdır Eserlerinde çağının sorunlarını ortaya koymuş eser kişilerinden hareketle çözümler de sunmuştur Epik tiyatronun bizdeki öncüsüdür ESERLERİ Öykü Yaşasın Demokrasi Şişhaneye Yağmur YağıyorduOn İkiye Bir Var Sanchonun Sabah Yürüyüşü Ayışığında Çalışkur Konçinalar Yalıda Sabah Tiyatro Günün Adamı Dışarıdakiler Huzur Çıkmazı Keşanlı Ali Destanı Gözlerimi Kaparım Vazifemi Yaparım Fazilet Eczanesi Zilli Zarife Portre / Anı Ölür İse Ten Ölür Canlar Ölesi Değil ATTİLA İLHAN (19252005)  Mavi akımının öncüsüdür Şiir roman deneme anı gezi yazısı türlerinde eserler vermiştir Daha çok bireysel ve toplumsal konuları işlediği şiirleriyle tanınmıştır ESERLERİ Şiir Duvar Sisler Bulvarı Ben Sana Mecburum Roman Kurtlar Sofrası Bıçağın Ucu NECATİ CUMALI (1921 2001)  Şiir hikaye roman ve tiyatro türlerinde eserler vermiştir Gözlemlerinden yola çıkarak toplumsal sorunları ele almıştır ESERLERİ Şiir Kızılçullu Yolu Roman Tütün Zamanı (Zeliş) Oyun Boş Beşik Ezik Otlar Susuz Yaz Yeni Çıkan Şarkılar ya da Juliet NURULLAH ATAÇ (1898 1957)  Deneme ve eleştiri türünde usta bir isimdir Batılı anlamda ilk deneme ve eleştiri yazılarının yazarıdır 1940tan sonraki yazılarında Türkçeyi özleştirme çabası öne çıkar ESERLERİ Deneme / Eleştiri Günlerin Getirdiği Karalama Defteri Sözden Söze Ararken Diyelim Söz Arasında Günce SUUT KEMAL YETKİN (19031980)  Deneme ve eleştiriyle tanınmıştır Sanat estetik resim ve felsefe alanlarında eserler vermiştir Düşüncelerini açık ve yalın bir anlatımla kaleme almıştır ESERLERİ Deneme Edebiyat Konuşmaları Edebiyat Üzerine Günlerin Götürdüğü Düşün Payı Yokuşa Doğru Şiir Üzerine Düşünceler Denemeler İnceleme  Araştırma Ahmet Haşim ve Sembolizm Sanat Felsefesi Edebiyatta Akımlar CEMİL MERİÇ (19171987)  Deneme türünün usta isimlerindendir Denemeleri dışında edebiyat tarihi felsefe tarih çalışmaları ve çevirileri de vardır ESERLERİ Deneme Bu Ülke Mağaradakiler Araştrıma/İnceleme Umrandan Uygarlığa Kırk Ambar Bir Dünyanın Eşiğinde RECEP BİLGİNER (19222005)  Şiirleri de olmasına karşın tiyatrocu olarak tanınmıştır Oyunlarında toplumsal konuları işlemiştir ESERLERİ Tiyatro İsyancılar Sarı Naciye Yunus Emre Parkta Bir Sonbahar Günüydü Mevlana Ben Kimim Karım ve Kızım TURAN OFLAZOĞLU (1932)  Tiyatro yazarıdır Oyunlarının konusunu köyden ve Türk tarihinden aldı ESERLERİ Tiyatro IV Murat Deli İbrahim Genç Osman Kösem Sultan Bizans Düştü Sokrates Savunuyor ORHAN ASENA (19222001)  Tiyatro yazarıdır Tarihten aldığı olayları ve topluma mal olmuş kişileri konu edinmiştir ESERLERİ Tiyatro Tohum ve Toprak Hürrem Sultan Tanrılar ve İnsanlar Fadik Kız Atçalı Kel Mehmet";
		String[] kelimeler = parcalanacak.toLowerCase().split("[ ]");
		String[] mailler = new String[] { "hotmail", "gmail", "outlook", "windowslive" };
		int kaldigiyer=3520; /*db.getCollection('users').find({}).count() sonucu + 1*/
		return args -> {
			StringBuilder sb;
			
			for (int i = kaldigiyer; i < 10000000; i++) {
				try {
				sb = new StringBuilder();
				User user = new User();
				int randomKelimeSayac = r.nextInt(9) + 1;
				while (randomKelimeSayac > 0) {
					sb.append(kelimeler[r.nextInt(kelimeler.length - 1)]).append(" ");
					randomKelimeSayac--;
				}
				user.setAddress(sb.toString());
				user.setBirtdate(LocalDateTime.of(r.nextInt(30) + 1980, (r.nextInt(11)+1), r.nextInt(25)+1, 1, 1));
				user.setEmail("email_" + i + "@" + mailler[r.nextInt(mailler.length - 1)] + ".com");
				user.setEmailVerified((r.nextInt(10) == 1));
				if (i < 1000) {
					followers[i] = user.getId();
				} else if (r.nextInt(10) > 4) {
					List<String> folowers = new ArrayList<>();
					int fCounter = r.nextInt(followers.length - 1);
					while (r.nextInt(10) > 4 && fCounter < followers.length - 1) {
						folowers.add(followers[fCounter]);
						fCounter++;
					}
					user.setFollowedUserId(folowers);
				}

				if (i < (1000+kaldigiyer)) {
					followers[(i-kaldigiyer)] = user.getId();
				} else if (r.nextInt(10) > 4 && i >= (1000+kaldigiyer)) {
					List<String> folowers = new ArrayList<>();
					int fCounter = r.nextInt(followers.length - 1);
					while (r.nextInt(10) > 4 && fCounter < followers.length - 1) {
						folowers.add(followers[fCounter]);
						fCounter++;
					}
					user.setFriendUserId(folowers);
				}

				user.setName(kelimeler[r.nextInt(kelimeler.length - 1)]);
				user.setPassive(r.nextInt(100) == 0);
				user.setPassword(kelimeler[r.nextInt(kelimeler.length - 1)]);
				user.setRegisteredTime(LocalDateTime.now());
				user.setLastLogin(LocalDateTime.now());
				user.setUserName("username" + i);
				user = userRepository.save(user);

				if (user != null && user.getId() != null) {
					if (i < (1000+kaldigiyer)) {
						followers[(i-kaldigiyer)]=user.getId();
					}
				}
				
				if((i%1000)==0)
				{
					Thread.sleep(500);
				}
				}catch(Exception e)
				{
					System.out.println(e.toString());
					e.printStackTrace();
					Thread.sleep(30000);
					
				}
			}
			
		};
		
	}

	// @Bean
	// public CommandLineRunner init(UserRepository userRepository, ShareRepository
	// shareRepository,
	// CommentRepository commentRepository) {
	//
	// return args -> {
	// log.info("CommandLineRunner is running");
	//
	// // user
	// /*
	// * List<Address> addresses = new ArrayList<>(); for (int i = 0; i < 240000;
	// i++)
	// * { Address address = new Address((i % 2 == 0) ? "address_ev" : "address_is",
	// * (long) Math.random() * 1000 + 10000L, "street-" + i, "district=" + i,
	// "city"
	// * + (int) Math.random() * 100, "country " + (int) Math.random() * 100, new
	// * double[] { 38.0 + Math.random() * 3, 26.0 + Math.random() * 5 });
	// * addresses.add(address); } List<AppUser> appUsers = new ArrayList<>();
	// * DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd"); for (int x
	// =
	// * 0; x < 120000; x++) { StringBuilder sbDate = new StringBuilder();
	// * sbDate.append(1925 + (int) (Math.random() * 10) * (int) (Math.random() *
	// * 10)).append("02").append("15"); AppUser appUser = new AppUser();
	// * appUser.setUserName("username_x" + x); appUser.setIsActive(true);
	// * appUser.setBirthDate(LocalDate.parse(sbDate.toString(),
	// df).atStartOfDay());
	// * appUser.setEmail(x + "email@mail.com"); appUser.setLastName("lastName-" +
	// x);
	// * appUser.setAddresses(addresses.subList(x * 2, x * 2 + 2));
	// * appUsers.add(appUser); } //appUsers.forEach(userRepository::insert);
	// * userRepository.saveAll(appUsers); log.info("appusers are saved");
	// */
	// /*
	// *
	// * List<AppUser> users = userRepository.findAll(); // shares Random r = new
	// * Random(); String[] tags = new String[] { "gunaydin", "hello", "hi",
	// "selam",
	// * "tag1", "deneme", "test" }; List<Share> shares = new ArrayList<>(); for
	// (int
	// * y = 0; y < 2000000; y++) { AppUser user = users.get(r.nextInt(users.size()
	// -
	// * 1)); Share share = new Share(); share.setLikeCount((long) r.nextInt(500));
	// * share.setTags(Arrays.copyOfRange(tags, 0, r.nextInt(tags.length - 1)));
	// * share.setIsDeleted(false); share.setAuthorUserId(user.getId());
	// * share.setText("sample text " + ((char) (48 + r.nextInt(48))) +
	// * " .AnonymousAuthenticationFi
	// org.springframework.security.web.session.Session"
	// * ); share.
	// * setExtra1("Extra text for testing....Registering beans for JMX exposure on
	// startup"
	// * ); share.
	// * setExtra2("Extra text for testing....Tomcat started on port(s): 8083 (http)
	// with context path"
	// * ); share.setExtra3(
	// * "Extra text for testing....Started Mongotest4Application in 19.311 seconds
	// (JVM running for 24.898)"
	// * ); shares.add(share); //Share savedShare = shareRepository.insert(share);
	// * //List<String> sId = user.getShareIds(); //sId.add(savedShare.getId());
	// * //user.setShareIds(sId); //userRepository.save(user); }
	// *
	// * shareRepository.saveAll(shares); log.info("shares are inserted.");
	// */
	// // comments
	//
	// ClassPathResource resource = new
	// ClassPathResource("static/dictionary_turkish.txt");
	// List<String> dicts = new ArrayList<>();
	// File file = resource.getFile();
	// try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	// String line;
	// while ((line = br.readLine()) != null) {
	// // process the line.
	// dicts.add(line);
	// }
	// }
	// log.info("words count " + dicts.size());
	//
	// List<User> users = userRepository.findAll();
	// log.info("comments, find all users.");
	// Page<Share> sharesList =
	// shareRepository.findAll(PageRequest.of(1100000,1300000));
	// List<Share> shares = sharesList.getContent();
	// log.info("comments, find all shares.");
	// List<Comment> comments = new ArrayList<>();
	// Random r2 = new Random();
	//
	// for (int b = 0; b < 999000; b++) {
	// String word1 = dicts.get(r2.nextInt(dicts.size() - 1));
	// String word2 = dicts.get(r2.nextInt(dicts.size() - 1));
	// String word3 = dicts.get(r2.nextInt(dicts.size() - 1));
	// Share share = shares.get(r2.nextInt(shares.size() - 1));
	// User user = users.get(r2.nextInt(users.size() - 1));
	// Comment comment = new Comment();
	// comment.setCommentUserId(user.getId());
	// comment.setExtra1(word1+"word thread successfully connected to server with
	// description.");
	// comment.setExtra2("Tomcat started on port(s): 8083 (http) with context
	// path."+word2);
	// comment.setExtra3("Opened connection [connectionId{localValue:2,
	// serverValue:129}] to 18.194.249.192:27017.");
	// comment.setExtra4("Discovered cluster type of STANDALONE");
	// comment.setExtra5("Registering beans for JMX exposure on startup");
	// comment.setIsDeleted(false);
	// comment.setLikeCount((long) r2.nextInt(100));
	// comment.setText("comment text Use copyOfRange method from java.util.Arrays.
	// search for " + word3 + " in the comment.");
	// comment.setSharedId(share.getId());
	// comments.add(comment);
	// }
	// log.info("comments inserting has been started.");
	//
	// commentRepository.saveAll(comments);
	//
	// log.info("comments are inserted.");
	//
	//
	// };
	//
	// }

	// Initializer
	/*
	 * @Bean public CommandLineRunner init(TemplateUserRepository
	 * userRepository,ShareRepository shareRepository, CommentRepository
	 * commentRepository) {
	 * 
	 * 
	 * return args->{
	 * 
	 * // List<User>
	 * users=userRepository.findByCityAndDistrict("city0","district=2");
	 * 
	 * List<TemplateUser> users=userRepository.findByCity(PageRequest.of(0,
	 * 3),"city0");
	 * 
	 * System.out.println(
	 * "#############################################################################"
	 * ); for(TemplateUser u : users) { System.out.println(u); } System.out.println(
	 * "#############################################################################"
	 * ); String email="hacihussam@gicikmail2.com"; Optional<TemplateUser>
	 * sonuc=userRepository.findByEmail(email);
	 * 
	 * if(sonuc.isPresent()) { System.out.println("Adam Var"); return; }
	 * 
	 * DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyyMMdd"); TemplateUser
	 * u1=new TemplateUser(); u1.setEmail(email);
	 * u1.setBirthDate(LocalDate.parse("19760101", df).atStartOfDay());
	 * u1.setIsActive(true); u1.setUserName("hacihussam2"); u1.setName("Hacı");
	 * u1.setLastName("Hussam");
	 * 
	 * u1=userRepository.insert(u1);
	 * 
	 * Share s1 = new Share(); s1.setAuthorUserId(u1.getId());
	 * 
	 * StringBuilder sb=null; Random r = new Random(); String alphabet =
	 * "12345 67890abcçdefg ğhıijklmnoöprsştuüvyz "; sb=new StringBuilder(); for(int
	 * i=0; i<256 ; i++) { sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
	 * 
	 * } s1.setExtra1(sb.toString()); sb=new StringBuilder(); for(int i=0; i<256 ;
	 * i++) { sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
	 * 
	 * } s1.setExtra2(sb.toString()); sb=new StringBuilder(); for(int i=0; i<256 ;
	 * i++) { sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
	 * 
	 * } s1.setExtra3(sb.toString());
	 * 
	 * s1.setIsDeleted(false); s1.setLikeCount((long) (r.nextInt(79)));
	 * 
	 * sb=new StringBuilder(); for(int i=0; i<256 ; i++) {
	 * sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
	 * 
	 * } s1.setText(sb.toString());
	 * 
	 * s1=shareRepository.insert(s1);
	 * 
	 * 
	 * Comment c1 = new Comment(); c1.setCommentUserId(u1.getId()); sb=new
	 * StringBuilder(); for(int i=0; i<256 ; i++) {
	 * sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
	 * 
	 * } c1.setText(sb.toString()); c1.setLikeCount((long) r.nextInt(10));
	 * c1.setSharedId(s1.getId()); c1.setIsDeleted(false);
	 * 
	 * c1=commentRepository.insert(c1);
	 * 
	 * System.out.println((c1.getId()!=null)?"Başarılı - "+c1.getId():" Başarısız");
	 * 
	 * }; }
	 */
}
