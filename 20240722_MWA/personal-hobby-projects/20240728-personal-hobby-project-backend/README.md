# Japanese Games

This project is my personal hobby project enlisting the japanese animes that people watch all over the world.

## 1. Configuration

The configuration includes two-step process for pacakge installation and config files setup.

### 1.1 Package Installation

To setup the project for production, run:

```bash
npm install --production
```

Otherwise, run:

```bash
npm install

```

### 1.2 .env setup

Project by default doesn't have a `.env` file. You will need to setup a `.env` file using the `.env.example` file provided.

**File: .env.example**

```
PORT=< APP-PORT-HERE >
MONGODB_CONNECTION_URL = < MONGODB-CONNECTION-URL-HERE>
```

Sample `.env` would look as follows:

**File: .env**

```
PORT=3000
MONGODB_CONNECTION_URL = mongodb://localhost:27017/japaneseAnimes
```

## 2. Importing Data to MongoDB

We have a file inside `data/backup/animes.json`

```bash
mongoimport -d japaneseAnimes -c animes --file=data/animes.json --jsonArray --drop
```

>**NOTE:** Be careful when copy-pasting above commands. We are dropping all data before importing the collection. Make sure you really want to drop it as you'll not be asked for confirmation.<br><br>You might need to include a separate DB_URL if your `mongodb` is on a different machine over the network.

## 3. Feedback

I have done my very best to follow SOLID, DRY and KISS principles to the best of my knowledge. However, I may fall short on some instances.

Your feedback on sakai or my student email avaialbe to you would be greatly appreaciated. Your feedback could be the ONE thing I might be missing in my life for breaking BIG.

Thank you for having your look into the project and giving me your time. I hope you have a blessed day.

