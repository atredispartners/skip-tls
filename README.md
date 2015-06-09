# skip-tls

SkipTLS - hacked up version of tlslite (https://github.com/trevp/tlslite) to exploit https://www.smacktls.com/#skip

To obtain certificates: 
    - openssl s_client -showcerts -host www.google.com -port 443
    - copy all of the certs (in the displayed order) into a .pem file

Running skip-tls:

sudo ./skiptls.py server -c www.google.com.pem --skipTls 127.0.0.1:443

Currently, all the code does is return the contents of squirrel.txt to the client. Proxying to a real host (like an inline burpsuite, or similar) has not been implemented.
