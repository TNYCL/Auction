package com.craftrise.data;

import com.craftrise.util.ChatUtil;

public interface Message {
	
	String[] COMMAND_INFO = {
		ChatUtil.color("&e&l           ------&6&l �hale &e&l------"),
		"",
		ChatUtil.color(" &6/ihale &f- &e�halede sat��a sunulan e�yalar� g�sterir."),
		ChatUtil.color(" &6/ihale incele <sat�� numaras�> &f- &e�halede sat��ta ki bir �r�n� koduyla a�ar."),
		ChatUtil.color(" &6/ihale y�net &f- &e�halede sat��ta olan b�t�n e�yalar�n�z� g�sterir."),
		ChatUtil.color(" &6/ihale artt�r <sat�� numaras�> <fiyat> &f- &e�halede ki bir �r�ne teklif verir."),
		ChatUtil.color(" &6/ihale ba�lat <miktar> <fiyat> &f- &eElinizde ki e�yay� ihaleye ��kart�r."),
		"",
		ChatUtil.color("&e&l           ------&6&l �hale &e&l------")
	};
	String NOT_FOUND_AUCTION_ID = "&b%id% &cnumaral� bir ihale bulunamad�!";
	String NOT_FOUND_AUCTION_USER = "&b%player% &cisimli oyuncuya ait bir ihale bulunamad�!";
	String AUCTION_ID_NOT_INTEGER = "&cL�tfen ge�erli bir ihale numaras� girin.";
	String ENTER_CORRECTLY_VALUE = "&cL�tfen ge�erli bir de�er girin.";
	String AMOUNT_GREATER = "&cGirdi�iniz miktar sahip oldu�unuz miktardan fazla olamaz! Toplamda: &b%amount% &cadete sahipsin.";
	String AMOUNT_EQUALS_ZERO = "&cGirdi�iniz miktar s�f�ra e�it olamaz.";
	String NOT_FOUND_ITEM_IN_HAND = "&cElinde bir e�ya olmas� gerekiyor.";
	String OFFER_CREATED = "&b%id% &enumaral� ihaleyi &b%price% &efiyat�yla ba�latt�n�z.";
	String OFFER_BID = "&b%id% &enumaral� ihaleye ba�ar�yla teklif verildi. Teklifiniz: &b%price%";
	String OFFER_BID_OWNER = "&b%id% &enumaral� ihalenize &b%player% &eisimli oyuncu teklif verdi. Verilen teklif: &b%price%";
	String ERROR = "&cBir hata olu�tu, l�tfen tekrar deneyin.";

}
