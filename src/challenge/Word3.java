package challenge;
//動詞を記憶させるクラス

import java.util.ArrayList;
import java.util.List;

/**
 * 動詞クラス
 * @author hatopoppo
 */
public class Word3
{

	/**
	 * 動詞、文章のパターンを決定
	 */
	List<String> list3=new ArrayList<>();

	/**
	 * 前半部分で用いる可能性がある動詞のリスト
	 */
	List<String> sublist=new ArrayList<>();

	/**
	 * Word3のデフォルトコンストラクタ
	 */
	public Word3()
	{
		list3.add("食べたい");
		list3.add("を豊かに");
		list3.add("が欲しい");
		list3.add("に行きたい");
		list3.add("を買いたい");

		sublist.add("予約した");
		sublist.add("貸切った");
	}
}