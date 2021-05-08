package com.craftrise.data;

import com.craftrise.util.ChatUtil;

public interface Message {
	
	String[] COMMAND_INFO = {
		ChatUtil.color("&e&l           ------&6&l Ýhale &e&l------"),
		"",
		ChatUtil.color(" &6/ihale &f- &eÝhalede satýþa sunulan eþyalarý gösterir."),
		ChatUtil.color(" &6/ihale incele <satýþ numarasý> &f- &eÝhalede satýþta ki bir ürünü koduyla açar."),
		ChatUtil.color(" &6/ihale yönet &f- &eÝhalede satýþta olan bütün eþyalarýnýzý gösterir."),
		ChatUtil.color(" &6/ihale arttýr <satýþ numarasý> <fiyat> &f- &eÝhalede ki bir ürüne teklif verir."),
		ChatUtil.color(" &6/ihale baþlat <miktar> <fiyat> &f- &eElinizde ki eþyayý ihaleye çýkartýr."),
		"",
		ChatUtil.color("&e&l           ------&6&l Ýhale &e&l------")
	};
	String NOT_FOUND_AUCTION_ID = "&b%id% &cnumaralý bir ihale bulunamadý!";
	String NOT_FOUND_AUCTION_USER = "&b%player% &cisimli oyuncuya ait bir ihale bulunamadý!";
	String AUCTION_ID_NOT_INTEGER = "&cLütfen geçerli bir ihale numarasý girin.";
	String ENTER_CORRECTLY_VALUE = "&cLütfen geçerli bir deðer girin.";
	String AMOUNT_GREATER = "&cGirdiðiniz miktar sahip olduðunuz miktardan fazla olamaz! Toplamda: &b%amount% &cadete sahipsin.";
	String AMOUNT_EQUALS_ZERO = "&cGirdiðiniz miktar sýfýra eþit olamaz.";
	String NOT_FOUND_ITEM_IN_HAND = "&cElinde bir eþya olmasý gerekiyor.";
	String OFFER_CREATED = "&b%id% &enumaralý ihaleyi &b%price% &efiyatýyla baþlattýnýz.";
	String OFFER_BID = "&b%id% &enumaralý ihaleye baþarýyla teklif verildi. Teklifiniz: &b%price%";
	String OFFER_BID_OWNER = "&b%id% &enumaralý ihalenize &b%player% &eisimli oyuncu teklif verdi. Verilen teklif: &b%price%";
	String ERROR = "&cBir hata oluþtu, lütfen tekrar deneyin.";

}
