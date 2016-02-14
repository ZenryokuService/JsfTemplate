package jp.zenryoku.frw;

import java.io.Serializable;

/**
 * このフレームワークで使用する<br>
 * すべてのエンティティに実装する、下記に実装ルールを示す<br>
 * 1.NamedQuery(name="findAll" query="SELECT * FROM 対象のエンティティ)を定義する<br>
 * 
 * @author ZenryokuService
 */
public interface EntityIF extends Serializable {
	/**
	 * BigHandsDaoで起動するクエリ名を返却するメソッド<br>
	 * "エンティティ.findAll"に対応するエリ名を取得する<br>
	 * NamedQuery(name="xxxxx" ......)で定義したクエリ名を返却する
	 * 
	 * @return 対象のクエリ名
	 */
	public String findAll();
}
