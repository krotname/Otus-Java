package ru.otus;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class HelloOtus {
    public static void main(String[] args) {

        HashFunction hf = Hashing.crc32();
        HashCode hc = hf.newHasher()
                .putLong(1)
                .putString("Andrei", Charsets.UTF_8)
                .hash();

        System.out.println("Gradle copy-past + guava work. HashCode = "+ hc);

    }
}
