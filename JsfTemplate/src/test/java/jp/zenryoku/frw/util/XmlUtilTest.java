package jp.zenryoku.frw.util;

import java.io.IOException;

import org.junit.Test;

public class XmlUtilTest {
	@Test
	public void testReadXml() {
		try {
			XmlUtil.readXml("filters.xml");
		} catch(IOException e) {
			
		}
	}

}
