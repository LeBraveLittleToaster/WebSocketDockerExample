FROM java

WORKDIR /usr/src/app

COPY build ./

EXPOSE 54321

CMD ["sh", "./install/Server/bin/Server"]