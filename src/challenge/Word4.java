package challenge;
import java.util.ArrayList;
import java.util.List;

/**
 * 形容詞、副詞を記憶するクラス
 * @author hatopoppo
 */
public class Word4
{
	/**
	 * 物リストを形容
	 */
	List<String> keiyoM=new ArrayList<>();

	/**
	 * 食べ物リストを形容
	 */
	List<String> keiyoT=new ArrayList<>();

	/**
	 * 場所リストを形容
	 */
	List<String> keiyoP=new ArrayList<>();

	/**
	 * Word4のデフォルトコンストラクタ
	 */
	public Word4()
	{
		keiyoM.add("新しい");
		keiyoM.add("古い");
		keiyoM.add("大きい");
		keiyoM.add("小さい");

		keiyoT.add("美味しい");
		keiyoT.add("まずい");
		keiyoT.add("甘い");
		keiyoT.add("辛い");

		keiyoP.add("遠い");
		keiyoP.add("近い");
		keiyoP.add("広い");
		keiyoP.add("狭い");
	}
}
