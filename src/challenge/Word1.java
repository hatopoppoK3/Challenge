package challenge;
//名詞を記憶させるクラス

import java.util.ArrayList;
import java.util.List;

/**
 * 名詞クラス
 * @author hatopoppo
 */
public class Word1
{
	/**
	 * 特定個人,団体を表すもの
	 */
	List<String> hito=new ArrayList<>();

	/**
	 * 食べ物
	 */
	List<String> tabemono=new ArrayList<>();

	/**
	 * 交通
	 */
	List<String> koutsu=new ArrayList<>();

	/**
	 * 公共交通機関
	 */
	List<String> pkoutsu=new ArrayList<>();

	/**
	 * 売れるもの
	 */
	List<String> sell=new ArrayList<>();

	/**
	 * koutsuリストとsellリストを合わせたもの
	 */
	List<String> mono=new ArrayList<>();

	/**
	 * 豊かにする物
	 */
	List<String> yutaka=new ArrayList<>();

	/**
	 * 場所
	 */
	List<String> basyo=new ArrayList<>();

	/**
	 * Word1クラスのデフォルトコンストラクタ
	 * 各々の種類の名詞をリストに追加
	 */
	public Word1()
	{
		hito.add("K3");
		hito.add("ゆっきー");
		hito.add("教授");
		hito.add("はなかっぱ");

		tabemono.add("焼肉");
		tabemono.add("寿司");
		tabemono.add("たこ焼き");
		tabemono.add("かき氷");
		tabemono.add("ラーメン");

		koutsu.add("車");
		koutsu.add("自転車");
		koutsu.add("リムジン");
		koutsu.add("プライベートジェット機");

		pkoutsu.add("電車");
		pkoutsu.add("バス");
		pkoutsu.add("新幹線");
		pkoutsu.add("飛行機");

		sell.add("PC");
		sell.add("スマホ");
		sell.add("家");
		sell.add("ディスプレイ");
		sell.add("Switch");

		mono.addAll(koutsu);
		mono.addAll(sell);

		yutaka.add("人生");
		yutaka.add("財布");
		yutaka.add("銀行口座");
		yutaka.add("余生");

		basyo.add("大学");
		basyo.add("海");
		basyo.add("山");
		basyo.add("遊園地");
		basyo.add("水族館");
	}
}
