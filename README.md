# skip-tls

SkipTLS - hacked up version of tlslite (https://github.com/trevp/tlslite) to exploit https://www.smacktls.com/#skip

To obtain certificates: 
    - openssl s_client -showcerts -host www.google.com -port 443
    - copy all of the certs (in the displayed order) into a .pem file

Running skip-tls:

sudo ./skiptls.py server -c www.google.com.pem --skipTls 127.0.0.1:443

Diverting a connection:

    - For testing, something simple like editing /etc/hosts or using dnsmasq to push custom DNS entries works fine.
    - IRL, use any MITM technique.

A very simple Java client is included. If you don't get a certificate error and see the output, you're running a vulnerable version of Java.

Currently, all the code does is return the contents of squirrel.txt to the client. Proxying to a real host (like an inline burpsuite, or similar) has not been implemented.
