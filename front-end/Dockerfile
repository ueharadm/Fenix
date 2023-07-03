FROM node:20-alpine3.18

COPY package.json .

RUN npm i

COPY . .

RUN npm run start

CMD [ "sh" ]