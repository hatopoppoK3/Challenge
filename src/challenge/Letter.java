package challenge;
import java.util.Random;

//sentenceを完成させるクラス。親クラス。

/**
 * 文章作成クラス
 * @author hatopoppo
 */
public class Letter
{
	/**
	 * ツイート文章
	 */
	String Sentence;
	Random rand;

	Kouhan kouhan;

	/**
	 * Letterクラスのデフォルトコンストラクタ
	 */
	public Letter()
	{
		Sentence=null;
		rand=new Random();
		kouhan=new Kouhan();
	}

	/**
	 * 文章作成の関数
	 * keyを引数とする
	 * @param a
	 */
	public void Making(String a)
	{
		kouhan.zenhanf(a);
		Sentence=kouhan.Sentence1;
		System.out.println("前半部分:"+kouhan.Sentence1);
		kouhan.kouhanf(a);
		System.out.println("後半部分:"+kouhan.Sentence2+"\n");
		Sentence=Sentence+kouhan.Sentence2;

		if((rand.nextFloat()<0.05))
		{
			System.out.println("5%の確率で文章変更");
			Sentence="処女じゃないエロゲーを買うのかbyNわか";
		}
		Sentence=Sentence+"\n\n#にわかちゃれんじ";
		System.out.println(Sentence);
	}
}
