package example

import java.security.spec.PKCS8EncodedKeySpec
import java.security.{KeyFactory, Security}

import javax.crypto.Cipher
import org.bouncycastle.jce.provider.BouncyCastleProvider

import scala.collection.StringOps

object Hello extends Greeting with App {
  Security.addProvider(new BouncyCastleProvider)
  val pemPrivateKey = "-----BEGIN RSA PRIVATE KEY-----\nMIIEpAIBAAKCAQEAxE0BoS88cuevUSZxRjm3IDP8QEJ/gqp/if/CibmW/K7PqrsY\nfqdt13qxpvS6rOufk3pOiGh6RJJ8ITJ1VLFO6M2ahrjArAP10XmnjJNjijNDpJtt\nK3UdGNoeR8wlxxmltmjfd16d/AIGu9Eng+Mfp4lkBiQdPtd28aHQtqgEYvMmQA/I\nQYtHB5Wrs82Z5p5FRA3CA1ylWNKHjZWI6aSg4Cm8rCYz3Z/0gpcnAqKUrnmsFv4z\nvyv2mICA081HIFDoLDugUpIY6nWQq+GVAy9a4/ZnphPbfOLDrvzRyo+vtaeYFpPC\n+whiAmt9MuJE1A1ij3O5QtK2K+5bejyBhi3J/wIDAQABAoIBABbVOjZMb0SSTGMt\nDIn1lqZpRZMX6QsC1/juReuNKdHUZ5VdU9kPkog43kckOj543cPiuxXEyUwGmeem\nnd0vDpWnrKy0+rxHbaVi+Ckyz6Y4lkqkRYuDgNHuNQ124oIJKqxQAIY6/Dde6PeZ\nuXXuyjTLl1Xbh4dSuqQahVNpsbDskRrKrDuHLIYEIPnuudT+8cBcLGVlLP2IMycz\ndbbyNBig1fOpNsS7yG0BG9kl4gFCHeLepbFbAtVZPmzYI3ohgpcyVJ93+wbEofzo\nDWIgltPXKJBHvcfybAS/Ffft+PimMscjOcQxzdYWJRz3B/x9iGkIAuy7woMGNnby\nLbJA+XkCgYEA8rTyWSxYtWQEKWghI202flBedfjuQSAzI7rk2gM9EMxB3Z8Pv1+d\npYYs7Ai0BqM/Ur166DvNE2OJvRiQmtfi+AbLmYVcezGx+MUdF0hy2GG/IeTg8u1S\nd4dgEwOKdhFUezgrd3+cEUg3m1hLzFqJ2ALrkqrh1nkipTk4raSUxjMCgYEAzw1j\np36qsSqmMjL3hxthtQrKxpkauW4UZvdgFn0XooUunD0a8NES5JqA+IH74ctIWR1z\nBalLmtMI1vALILz+uM/fMOMm9RyvA/O6pEa1oHvEvghiOWePW7s84GSgHIFCPW6+\nxfGUv2tRXG00WAzKIpeIYybHOSLWI8LsolUZaQUCgYEA4DohyBa7YeGkIqkMLJGi\njbIsgutXGp3oATOSaIQjb5h1pY1lXBW3LIw4hlxIDfXV89gQa+uLvETypNvEBPo8\nu45znULjPQGdfcqF5NPPHm+3yFWPKX/t93X/YbGcwxWhqjErnzwq8KB6ly9M3+Ap\nh4KzJw5ulNnXEzQ5U9tAg5cCgYB88QxwlzvzWtQdOKorijdkoxWHz/3TZXzEQYRn\nLackeA+PUkQ+iztGXYFz9CQFtcB7ngy5ntYzoCMWaJWedM2UwkNhYcExadSmot2+\nobiaFfW74p07HKXiadMraS1A5jMNlRVjpwrmk6DuECvk8hrL0vsHMfBIJyBnRgm7\nT3Tc7QKBgQCPf/TBhAz/r2qLuHoujguVofPq0tNmwkN3P5XXf7Jcrndq6Ku7/YfD\nwuQI7bKjmHPUqY9LgIM4OXft4twoAgjl4/LGJqrAwVtbmTSRT90pFp+7joOFkfvL\nclUL8V6L5xUY51Il4G6oDQfn6zKym0+XGPJeOt5pCBWl6Bfy58Yrog==\n-----END RSA PRIVATE KEY-----\n"
  val b64EncodedMessageHash = "MOaqw44W81AoA3zDmpEIUGQ7GJssLITpCbCq0itUvlv81MQUlS9A5vahEPhwAUwQ/gK5THMk23+dKJHqXeTyK21bosE4bAFq22/gB8E0c0ODu0LTPewCENqPOk0nl9SqukHV7LCvcw366bhkcuVVgrrSHCW8PEuisdeWG6xrqFad8/5m5HkV92IIP25/VYWix6/ATeTzbSQpA4dIBlWPqStNTCRNPfXrFDHJdJ4+KzVqCZqX17ul5jiWDU5b0JFZTDPyE1dEa8NXdlO62UHdMGdwflZnk5d4VOV8nJx2hDa5aIHo9KqzX8FLEUIQtt4rLGcADlzHcHLsBIT3nqneSQ=="
  val b64EncodedPemPrivateKey = new StringOps(pemPrivateKey).linesIterator
    .filterNot(line => line.contains("BEGIN RSA") || line.contains("END RSA"))
    .mkString("")
  val expectedB64EncodedSignature = "Q28zss1mCGNPeptbixo0eqKHyKB/3eCrvC9SVc4HXdR0GaWAl0OpKcsk8XYV1TW/TNxVQKbBLqSwIEKR/Aj6PII4149o8QwoFvM3rVl2eoq+Mdsda1kNKWRouPush6hm1tH9FNDy54krwUWEIUqouRhiu5h+8PWZhCZrUugN9kPboiaMQC7QUw3xCgEhHamwGL6Bs4pWiEJEttWg31UrWtthbQpDqatFWR1y1iZ16RqfIJkgVo0H2GvIptoHaMnZ3hAHs3ipEEYL9QY0MmByXj2z3Nki3QdGMWVUVgsNVofPvFjMXlJD6Cd68s0CILyMSbJold1SYYuxOc2pkdaICw==";

  val b64Decoder = java.util.Base64.getDecoder

  val keyFactory = KeyFactory.getInstance("RSA")
  val keySpecPKCS8 = new PKCS8EncodedKeySpec(b64Decoder.decode(b64EncodedPemPrivateKey))
  val privateKey = keyFactory.generatePrivate(keySpecPKCS8)

  val messageHash = b64Decoder.decode(b64EncodedMessageHash);

  val encrypt = Cipher.getInstance("RSA/NONE/NOPADDING", "BC");
  encrypt.init(Cipher.ENCRYPT_MODE, privateKey);
  val signature = encrypt.doFinal(messageHash)
  val b64EncodedSignature = java.util.Base64.getEncoder.encodeToString(signature)

  println("expectedB64EncodedSignature")
  println(expectedB64EncodedSignature)
  println("b64EncodedSignature")
  println(b64EncodedSignature)
  println("equal: " + (expectedB64EncodedSignature == b64EncodedSignature).toString)
}

trait Greeting {
  lazy val greeting: String = "hello"
}
