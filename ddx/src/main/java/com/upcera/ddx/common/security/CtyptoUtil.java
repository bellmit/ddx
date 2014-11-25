package com.upcera.ddx.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component("CtyptoUtil")
public class CtyptoUtil {
	static int MD5LEN = 16;

	static int MD5MAXSIZE = 1024;

	// 密钥值
	public static String SECRET = "admin@upcera.com";

	public CtyptoUtil() {

	}

	public static String EncryptString(String Source) throws Exception {
		try {
			int i = 0, j;
			byte[] Hv = new byte[MD5LEN];
			byte[] Vector = new byte[MD5LEN];
			byte[] Secretb = SECRET.getBytes();
			byte[] Sourcetb = Source.getBytes();
			byte[] dest = new byte[Source.length()];
			byte[] password = new byte[SECRET.length() + Vector.length];
			do {
				for (int m = 0; m < SECRET.length(); m++)
					password[m] = Secretb[m];
				for (int m = 0; m < Vector.length; m++)
					password[SECRET.length() + m] = Vector[m];
				Hv = CtyptoUtil.md5Digest(password);
				for (j = 0; j < MD5LEN; j++)
					if ((i + j) < Source.length()) {
						dest[i + j] = new Integer(Sourcetb[i + j] ^ Hv[j]).byteValue();
					} else
						break;
				i += MD5LEN;
				if (i < Source.length()) {
					Vector = CtyptoUtil.Clear(Vector);
					if ((Source.length() - i + 1) < MD5LEN) {
						for (int m = 0; m < Source.length() - i + 1; m++)
							Vector[m] = dest[i - MD5LEN + m];
					} else {
						for (int m = 0; m < MD5LEN; m++)
							Vector[m] = dest[i - MD5LEN + m];
					}
				}
			} while (i <= Source.length());
			return CtyptoUtil.byte2hex(dest);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static byte[] md5Digest(byte[] password) throws Exception {
		try {
			MessageDigest alg = MessageDigest.getInstance("MD5");
			alg.update(password);
			byte[] digest = alg.digest();
			return digest;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static String byte2hex(byte[] bytes) throws Exception {
		try {
			String hs = "";
			String stmp = "";
			for (int i = 0; i < bytes.length; i++) {
				stmp = (java.lang.Integer.toHexString(bytes[i] & 0XFF));
				if (stmp.length() == 1)
					hs = hs + "0" + stmp;
				else
					hs = hs + stmp;
			}
			return hs.toUpperCase();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static byte[] Clear(byte[] ss) throws Exception {
		try {
			for (int m = 0; m < ss.length; m++) {
				ss[m] = new Integer(0).byteValue();
			}
			return ss;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static byte[] HexToBuf(String auth) {
		int Leth = auth.length() / 2;
		byte[] HexByte = new byte[Leth];
		for (int a = 0; a < Leth; a++) {
			HexByte[a] = (byte) Integer.parseInt(auth.substring(a * 2, a * 2 + 2).toLowerCase(), 16);
		}
		return HexByte;
	}

	public static String DecryptString(String Cryptograph) throws NoSuchAlgorithmException, Exception {
		int i = 0, j;
		byte[] Hv = new byte[MD5LEN];
		byte[] Vector = new byte[MD5LEN];
		byte[] Secretb = SECRET.getBytes();
		byte[] Source = CtyptoUtil.HexToBuf(Cryptograph);
		byte[] dest = new byte[Source.length];
		byte[] password = new byte[SECRET.length() + Vector.length];
		do {

			for (int m = 0; m < SECRET.length(); m++)
				password[m] = Secretb[m];

			for (int m = 0; m < Vector.length; m++)
				password[SECRET.length() + m] = Vector[m];

			Hv = CtyptoUtil.md5Digest(password);
			for (j = 0; j < MD5LEN; j++)
				if ((i + j) < Source.length)
					dest[i + j] = new Integer(Source[i + j] ^ Hv[j]).byteValue();
				else
					break;
			i += MD5LEN;
			if (i < Source.length) {
				Vector = CtyptoUtil.Clear(Vector);
				if ((Source.length - i + 1) < MD5LEN) {
					for (int m = 0; m < Source.length - i + 1; m++)
						Vector[m] = Source[i - MD5LEN + m];
				} else {
					for (int m = 0; m < MD5LEN; m++)
						Vector[m] = Source[i - MD5LEN + m];
				}
			}
		} while (i <= Source.length);
		return new String(dest);
	}

	public static void main(String[] args) throws Exception, NoSuchAlgorithmException {
		String password = CtyptoUtil.EncryptString("123456");
		System.out.println(password);
		System.out.println(CtyptoUtil.DecryptString(password));
	}
}
