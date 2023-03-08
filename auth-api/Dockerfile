FROM node:14
WORKDIR .
COPY package*.json ./
RUN yarn --network-timeout=3000000
COPY . .
EXPOSE 8080
CMD ["node", "app.js"]