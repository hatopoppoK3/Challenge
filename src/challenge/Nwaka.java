package challenge;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.regex.*;
import twitter4j.*;

/**
 * mainクラス
 * @author hatopoppo
 */
public class Nwaka {

	/**
	 * 上限のtweet文字数
	 */
	static final int N=140;

	/**
	 * 書き込みの関数
	 * 文字列を入力された際にyesかnoが入力されなかったらexit(0)
	 * @param a
	 * @return line:(yes)or(no)
	 */
	public static String Reading(String a)
	{
		String line=null;

		try
		{
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n"+a+"?"+"(yes/no)");
			line=new String(bufferedReader.readLine());
			if(!((line.equals("yes"))||(line.equals("no"))))
			{
				throw new IllegalArgumentException("yesかnoで解答してください。");
			}
		}
		catch (IOException ex)
		{
			//例外発生時処理
			ex.printStackTrace();
		}
		catch(IllegalArgumentException ex)
		{
			System.out.println("例外が発生しました。");
			System.out.println(ex);
			System.exit(0);
		}

		return line;
	}

	/**
	 * ツイートする文字列の決定
	 * @param let
	 * @return let.Sentence:ツイートする文字列
	 */
	public static String Decide(Letter let)
	{
		String key;
		Random rand=new Random();

		key=let.kouhan.word3.list3.get(rand.nextInt(let.kouhan.word3.list3.size()));
		let.Making(key);
		if(let.Sentence.length()>N)
		{
			System.out.println("tweetできる文字数を超えているため、文章を作り直します。");
			Decide(let);
		}

		if(Reading("文章を作り直す").equals("yes"))
		{
			Decide(let);
		}

		return let.Sentence;
	}

	public static void main(String[] args)
	{
		// TODO 自動生成されたメソッド・スタブ

		/**
		 * ツイート内容
		 */
		String tweet=null;
		/**
		 * ユーザー名
		 */

		String tmp=null;
		/**
		 * 正規表現で@をなくす
		 */

		Pattern pattern=Pattern.compile("@(\\S)");
		Matcher matcher;
		Desktop desktop=Desktop.getDesktop();

		/**
		 * tweetdeckのURI
		 */
		URI url;

		/**
		 * twitter4j
		 */
		Twitter twitter=TwitterFactory.getSingleton();

		/**
		 * ツイート作成クラス
		 */
		Letter letter=new Letter();

		try
		{
			long cursor=-1;
			IDs ids;

			/**
			 * このユーザー名のフォロワー情報の取得
			 */
			String ScreenName="*******";

			/**
			 * フォロワーのIDを格納
			 */
			List<Long> followerIDs=new ArrayList<>();

			do
			{
				ids=twitter.getFollowersIDs(ScreenName,cursor);
				for(long id:ids.getIDs())
				{
					followerIDs.add(id);
				}
				cursor=ids.getNextCursor();
			}
			while(ids.hasNext());

			for(long id:followerIDs)
			{
				tmp=twitter.showUser(id).getName();
				matcher=pattern.matcher(tmp);
				letter.kouhan.word1.hito.add(matcher.replaceAll(""));
			}
		}
		catch(TwitterException e)
		{
			e.printStackTrace();
		}

		tweet=Decide(letter);

		if(Reading("tweetする").equals("yes"))
		{
			try
			{
				twitter.updateStatus(tweet);
				System.out.println("tweet出来ました。");
			}
			catch(TwitterException e1)
			{
				System.out.println("tweet出来ませんでした。");
				e1.printStackTrace();
			}
		}

		if(Reading("tweetdeckを開く").equals("yes"))
		{
			try
			{
				System.out.println("tweetdeckを開く");
				url = new URI("https://tweetdeck.twitter.com/");
				desktop.browse(url);
			}
			catch(URISyntaxException e)
			{
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			catch(IOException e)
			{
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}