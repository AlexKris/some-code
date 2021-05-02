package com.chris.some.code.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;

/**
 * Base64
 */
public class Base64 {

    private static final char[] S_BASE64CHAR = {'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', '+', '/'};

    private static final byte[] S_DECODE_TABLE;

    static {
        S_DECODE_TABLE = new byte[128];
        Arrays.fill(S_DECODE_TABLE, (byte) 127);

        for (int i = 0; i < S_BASE64CHAR.length; i++)
            S_DECODE_TABLE[S_BASE64CHAR[i]] = (byte) i;
    }

    private static int decode0(char[] inputBuf, byte[] outputBuf, int wp) {
        int outLen = 3;
        if (inputBuf[3] == '=')
            outLen = 2;
        if (inputBuf[2] == '=')
            outLen = 1;
        int b0 = S_DECODE_TABLE[inputBuf[0]];
        int b1 = S_DECODE_TABLE[inputBuf[1]];
        int b2 = S_DECODE_TABLE[inputBuf[2]];
        int b3 = S_DECODE_TABLE[inputBuf[3]];
        switch (outLen) {
            case 1: // '\001'
                outputBuf[wp] = (byte) (b0 << 2 & 252 | b1 >> 4 & 3);
                return 1;

            case 2: // '\002'
                outputBuf[wp++] = (byte) (b0 << 2 & 252 | b1 >> 4 & 3);
                outputBuf[wp] = (byte) (b1 << 4 & 240 | b2 >> 2 & 15);
                return 2;

            case 3: // '\003'
                outputBuf[wp++] = (byte) (b0 << 2 & 252 | b1 >> 4 & 3);
                outputBuf[wp++] = (byte) (b1 << 4 & 240 | b2 >> 2 & 15);
                outputBuf[wp] = (byte) (b2 << 6 & 192 | b3 & 63);
                return 3;
        }
        throw new RuntimeException("Internal error");
    }

    public static byte[] decode(char[] data, int off, int len) {
        char[] ibuf = new char[4];
        int ibufcount = 0;
        byte[] obuf = new byte[(len / 4) * 3 + 3];
        int obufcount = 0;
        for (int i = off; i < off + len; i++) {
            char ch = data[i];
            if (ch != '='
                    && (ch >= S_DECODE_TABLE.length || S_DECODE_TABLE[ch] == 127))
                continue;
            ibuf[ibufcount++] = ch;
            if (ibufcount == ibuf.length) {
                ibufcount = 0;
                obufcount += decode0(ibuf, obuf, obufcount);
            }
        }

        if (obufcount == obuf.length) {
            return obuf;
        } else {
            byte[] ret = new byte[obufcount];
            System.arraycopy(obuf, 0, ret, 0, obufcount);
            return ret;
        }
    }

    public static byte[] decode(String data) {
        char[] inputBuf = new char[4];
        int ibufcount = 0;
        byte[] outputBuf = new byte[(data.length() / 4) * 3 + 3];
        int obufcount = 0;
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch != '='
                    && (ch >= S_DECODE_TABLE.length || S_DECODE_TABLE[ch] == 127))
                continue;
            inputBuf[ibufcount++] = ch;
            if (ibufcount == inputBuf.length) {
                ibufcount = 0;
                obufcount += decode0(inputBuf, outputBuf, obufcount);
            }
        }

        if (obufcount == outputBuf.length) {
            return outputBuf;
        } else {
            byte[] ret = new byte[obufcount];
            System.arraycopy(outputBuf, 0, ret, 0, obufcount);
            return ret;
        }
    }

    public static void decode(char[] data, int off, int len, OutputStream outStream) throws IOException {
        char[] inputBuf = new char[4];
        int ibufcount = 0;
        byte[] outputBuf = new byte[3];
        for (int i = off; i < off + len; i++) {
            char ch = data[i];
            if (ch != '='
                    && (ch >= S_DECODE_TABLE.length || S_DECODE_TABLE[ch] == 127))
                continue;
            inputBuf[ibufcount++] = ch;
            if (ibufcount == inputBuf.length) {
                ibufcount = 0;
                int obufcount = decode0(inputBuf, outputBuf, 0);
                outStream.write(outputBuf, 0, obufcount);
            }
        }
    }

    public static void decode(String data, OutputStream ostream) throws IOException {
        char[] inputBuf = new char[4];
        int ibufcount = 0;
        byte[] outputBuf = new byte[3];
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch != '='
                    && (ch >= S_DECODE_TABLE.length || S_DECODE_TABLE[ch] == 127))
                continue;
            inputBuf[ibufcount++] = ch;
            if (ibufcount == inputBuf.length) {
                ibufcount = 0;
                int outputBufCount = decode0(inputBuf, outputBuf, 0);
                ostream.write(outputBuf, 0, outputBufCount);
            }
        }
    }

    public static String encode(byte[] data) {
        return encode(data, 0, data.length);
    }

    public static String encode(byte[] data, int off, int len) {
        if (len <= 0)
            return "";
        char[] out = new char[(len / 3) * 4 + 4];
        int rindex = off;
        int windex = 0;
        int rest;
        for (rest = len - off; rest >= 3; rest -= 3) {
            int i = ((data[rindex] & 255) << 16)
                    + ((data[rindex + 1] & 255) << 8)
                    + (data[rindex + 2] & 255);
            out[windex++] = S_BASE64CHAR[i >> 18];
            out[windex++] = S_BASE64CHAR[i >> 12 & 63];
            out[windex++] = S_BASE64CHAR[i >> 6 & 63];
            out[windex++] = S_BASE64CHAR[i & 63];
            rindex += 3;
        }

        if (rest == 1) {
            int i = data[rindex] & 255;
            out[windex++] = S_BASE64CHAR[i >> 2];
            out[windex++] = S_BASE64CHAR[i << 4 & 63];
            out[windex++] = '=';
            out[windex++] = '=';
        } else if (rest == 2) {
            int i = ((data[rindex] & 255) << 8) + (data[rindex + 1] & 255);
            out[windex++] = S_BASE64CHAR[i >> 10];
            out[windex++] = S_BASE64CHAR[i >> 4 & 63];
            out[windex++] = S_BASE64CHAR[i << 2 & 63];
            out[windex++] = '=';
        }
        return new String(out, 0, windex);
    }

    public static void encode(byte[] data, int off, int len, OutputStream outStream) throws IOException {
        if (len <= 0)
            return;
        byte[] out = new byte[4];
        int rindex = off;
        int rest;
        for (rest = len - off; rest >= 3; rest -= 3) {
            int i = ((data[rindex] & 255) << 16)
                    + ((data[rindex + 1] & 255) << 8)
                    + (data[rindex + 2] & 255);
            out[0] = (byte) S_BASE64CHAR[i >> 18];
            out[1] = (byte) S_BASE64CHAR[i >> 12 & 63];
            out[2] = (byte) S_BASE64CHAR[i >> 6 & 63];
            out[3] = (byte) S_BASE64CHAR[i & 63];
            outStream.write(out, 0, 4);
            rindex += 3;
        }

        if (rest == 1) {
            int i = data[rindex] & 255;
            out[0] = (byte) S_BASE64CHAR[i >> 2];
            out[1] = (byte) S_BASE64CHAR[i << 4 & 63];
            out[2] = 61;
            out[3] = 61;
            outStream.write(out, 0, 4);
        } else if (rest == 2) {
            int i = ((data[rindex] & 255) << 8) + (data[rindex + 1] & 255);
            out[0] = (byte) S_BASE64CHAR[i >> 10];
            out[1] = (byte) S_BASE64CHAR[i >> 4 & 63];
            out[2] = (byte) S_BASE64CHAR[i << 2 & 63];
            out[3] = 61;
            outStream.write(out, 0, 4);
        }
    }

    public static void encode(byte[] data, int off, int len, Writer writer) throws IOException {
        if (len <= 0)
            return;
        char[] out = new char[4];
        int rindex = off;
        int rest = len - off;
        int output = 0;
        while (rest >= 3) {
            int i = ((data[rindex] & 255) << 16)
                    + ((data[rindex + 1] & 255) << 8)
                    + (data[rindex + 2] & 255);
            out[0] = S_BASE64CHAR[i >> 18];
            out[1] = S_BASE64CHAR[i >> 12 & 63];
            out[2] = S_BASE64CHAR[i >> 6 & 63];
            out[3] = S_BASE64CHAR[i & 63];
            writer.write(out, 0, 4);
            rindex += 3;
            rest -= 3;
            if ((output += 4) % 76 == 0)
                writer.write("\n");
        }
        if (rest == 1) {
            int i = data[rindex] & 255;
            out[0] = S_BASE64CHAR[i >> 2];
            out[1] = S_BASE64CHAR[i << 4 & 63];
            out[2] = '=';
            out[3] = '=';
            writer.write(out, 0, 4);
        } else if (rest == 2) {
            int i = ((data[rindex] & 255) << 8) + (data[rindex + 1] & 255);
            out[0] = S_BASE64CHAR[i >> 10];
            out[1] = S_BASE64CHAR[i >> 4 & 63];
            out[2] = S_BASE64CHAR[i << 2 & 63];
            out[3] = '=';
            writer.write(out, 0, 4);
        }
    }
}
