package jp.zenryoku.frw.util;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class XmlUtilTest {
	@Test
	public void testReadXml() {
		try {
			XmlUtil.readXml("filters.xml");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
