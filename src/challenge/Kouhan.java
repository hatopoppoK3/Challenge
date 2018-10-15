package challenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Zenhanクラスを継承した後半部分の文章作成のクラス
 * @author hatopoppo
 */
public class Kouhan extends Zenhan
{
	/**
	 * 後半部分の文章
	 */
	String Sentence2;

	/**
	 * keyに対応するword1のリストを参照。
	 */
	Map<String,List<String>> kouhan=new HashMap<>();

	/**
	 * word1に対応する形容詞を参照。
	 */
	Map<List<String>,List<String>> keiyo=new HashMap<>();

	/**
	 * Kouhanクラスのデフォルトコンストラクタ
	 */
	public Kouhan()
	{
		super();

		kouhan.put("食べたい", word1.tabemono);
		kouhan.put("を豊かに", word1.yutaka);
		kouhan.put("が欲しい", word1.mono);
		kouhan.put("に行きたい", word1.basyo);
		kouhan.put("を買いたい", word1.mono);

		keiyo.put(word1.tabemono,word4.keiyoT);
		keiyo.put(word1.basyo,word4.keiyoP);
		keiyo.put(word1.mono,word4.keiyoM);

		Sentence2=null;
	}

	/**
	 * 文字の連結に関する関数:renketsu
	 * @param a
	 */
	public void renketsu2(List<String> a)
	{
		String tmp;

		if(!Sentence1.contains(tmp=a.get(rand.nextInt(a.size()))))
		{
			renketsu2(tmp);
		}
		else
		{
			renketsu2(a);
		}
	}

	/**
	 * sentenceに文字を追加するためのやつ。引数で少し異なる。
	 * @param a
	 */
	public void renketsu2(String a)
	{
		Sentence2=Sentence2+a;
	}

	/**
	 * 文章の完成
	 * @param a
	 */
	public void kouhanf(String a)
	{
		Sentence2="で";

		if(a=="食べたい")
		{
			if(rand.nextBoolean())
			{
				renketsu2(keiyo.get(kouhan.get(a)));
			}
			renketsu2(kouhan.get(a));
			//「～が」or「～を」となる
			if(rand.nextBoolean())
			{
				renketsu2("が");
			}
			else
			{
				renketsu2("を");
			}
		}
		else
		{
			//「hito.classの」を追加。
			if((rand.nextBoolean())&&(a!="に行きたい"))
			{
				kouhanf2();
			}
			else
			{
				if(keiyo.containsKey(kouhan.get(a)))
				{
					renketsu2(keiyo.get(kouhan.get(a)));
				}
			}
			renketsu2(kouhan.get(a));
		}
		renketsu2(a);
	}

	/**
	 * hitoクラスの～を～。
	 */
	public void kouhanf2()
	{
		String tmp;

		//前半部分の人とかぶらないようにするため、かぶっていないか調べる。
		if(!Sentence1.contains(tmp=word1.hito.get(rand.nextInt(word1.hito.size()))))
		{
			renketsu2(tmp+"の");
		}
		else
		{
			kouhanf2();
		}
	}
}
