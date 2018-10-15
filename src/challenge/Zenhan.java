package challenge;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 前半部分の文章の作成クラス
 * @author hatopoppo
 */
public class Zenhan
{
	/**
	 * 前半部分の文章
	 */
	String Sentence1;

	/**
	 * 助詞を格納
	 */
	String str;
	Random rand;

	/**
	 * keyに対応するword1のリストを参照,前半部分に使われるもの
	 */
	Map<String,List<String>> zenhan1=new HashMap<>();

	Word1 word1=new Word1();
	Word2 word2=new Word2();
	Word3 word3=new Word3();
	Word4 word4=new Word4();

	/**
	 * Zenhanクラスのデフォルトコンストラクタ
	 */
	public Zenhan()
	{
		zenhan1.put("の", word1.koutsu);
		zenhan1.put("が", word1.pkoutsu);

		Sentence1=null;
		str=null;
		rand=new Random();
	}

	/**
	 * "～で"の部分を作る。前半部分完成。
	 * @param a
	 */
	public void zenhanf(String a)
	{
		if(a=="に行きたい")
		{
			Sentence1=word1.hito.get(rand.nextInt(word1.hito.size()));
			if(rand.nextBoolean())
			{
				renketsu(str="の");
				renketsu(zenhan1.get(str));
			}
			else
			{
				renketsu(str="が");
				renketsu(word3.sublist.get(rand.nextInt(word3.sublist.size())));
				renketsu(zenhan1.get(str));
			}
		}
		else
		{
			Sentence1=word1.hito.get(rand.nextInt(word1.hito.size()));
			renketsu("の");
			renketsu(word1.mono);

			if(rand.nextFloat()<0.7)
			{
				renketsu("を売って得た金");
			}
			else
			{
				renketsu("と");
				renketsu(word1.hito.get(rand.nextInt(word1.hito.size())));
				renketsu("の");
				renketsu(word1.mono);
				zenhanf(a);
			}
		}
	}

	/**
	 * 文字の連結に関する関数:renketsu
	 * @param a
	 */
	public void renketsu(List<String> a)
	{
		String tmp;

		if(!Sentence1.contains(tmp=a.get(rand.nextInt(a.size()))))
		{
			renketsu(tmp);
		}
		else
		{
			renketsu(a);
		}
	}

	/**
	 * sentenceに文字を追加するためのやつ。引数で少し異なる。
	 * @param a
	 */
	public void renketsu(String a)
	{
		Sentence1=Sentence1+a;
	}
}
