package com.auction.data;

import com.auction.utils.UtilChat;

public interface Message {
	
	String[] COMMAND_INFO = {
		UtilChat.color("&e&l           ------&6&l İhale &e&l------"),
		"",
		UtilChat.color(" &6/ihale &f- &eİhalede satışa sunulan eşyalara gösterir."),
		UtilChat.color(" &6/ihale incele <satış numarası> &f- &eİhalede satışta ki bir ürünü koduyla açar."),
		UtilChat.color(" &6/ihale yönet &f- &eİhalede satışta olan bütün eşyalarınızı gösterir."),
		UtilChat.color(" &6/ihale arttır <satış numarası> <fiyat> &f- &eİhalede ki bir ürüne teklif verir."),
		UtilChat.color(" &6/ihale başlat <miktar> <fiyat> &f- &eElinizde ki eşyayı ihaleye çıkartır."),
		"",
		UtilChat.color("&e&l           ------&6&l İhale &e&l------")
	};
	String NOT_FOUND_AUCTION_ID = "&b%id% &cnumaralı bir ihale bulunamadı!";
	String NOT_FOUND_AUCTION_USER = "&b%player% &cisimli oyuncuya ait bir ihale bulunamadı!";
	String AUCTION_ID_NOT_INTEGER = "&cLütfen geçerli bir ihale numarası girin.";
	String ENTER_CORRECTLY_VALUE = "&cLütfen geçerli bir değer girin.";
	String AMOUNT_GREATER = "&cGirdiğiniz miktar sahip olduğunuz miktardan fazla olamaz! Toplamda: &b%amount% &cadete sahipsin.";
	String AMOUNT_EQUALS_ZERO = "&cGirdiğiniz miktar sıfıra eşit olamaz.";
	String NOT_FOUND_ITEM_IN_HAND = "&cElinde bir eşya olması gerekiyor.";
	String OFFER_CREATED = "&b%id% &enumaralı ihaleyi &b%price% &efiyatıyla başlattınız.";
	String OFFER_BID = "&b%id% &enumaralı ihaleye başarıyla teklif verildi. Teklifiniz: &b%price%";
	String OFFER_BID_OWNER = "&b%id% &enumaralı ihalenize &b%player% &eisimli oyuncu teklif verdi. Verilen teklif: &b%price%";
	String ERROR = "&cBir hata oluştu, lütfen tekrar deneyin.";

}
