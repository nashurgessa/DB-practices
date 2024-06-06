
## E-Chat App DB Design

Here is a possible design for an E-Chat app database:

#### User Table
Stores information about users.

```sql
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

#### Chat Table
Stores information about chats.
```sql
CREATE TABLE chats (
    chat_id SERIAL PRIMARY KEY,
	chat_name VARCHAR(255) NOT NULL, -- Optional for private chats, useful for group chats
	is_group BOOLEAN DEFAULT FALSE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

#### Chat Participants Table
Stores information about which `users` are part of which `chats`.

```sql
CREATE TABLE chat_participants (
	chat_id INT REFERENCES chats(chat_id) ON DELETE CASCADE,  
    user_id INT REFERENCES users(user_id) ON DELETE CASCADE,
    PRIMARY KEY (chat_id, user_id)

);
```

#### Message Table

Stores information about messages.

```sql
CREATE TABLE messages (
    message_id SERIAL PRIMARY KEY,
    chat_id INT REFERENCES chats(chat_id) ON DELETE CASCADE,
    sender_id INT REFERENCES users(user_id) ON DELETE SET NULL,
    payload_type VARCHAR(50) NOT NULL,
    payload TEXT NOT NULL,
    parent_msg_id INT REFERENCES messages(message_id) ON DELETE SET NULL,
    is_reminder BOOLEAN DEFAULT FALSE,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    received_date TIMESTAMP,
    expire_date TIMESTAMP
);
```

#### Message Receipts Table
Stores information about message receipts (which user has read which message, and other receipt information).

```sql
CREATE TABLE message_receipts (
    id SERIAL PRIMARY KEY,
    message_id INT REFERENCES messages(message_id) ON DELETE CASCADE,
    target_id INT REFERENCES users(user_id) ON DELETE CASCADE,
    target_group_id INT REFERENCES chats(chat_id) ON DELETE CASCADE,
    is_read BOOLEAN DEFAULT FALSE,
    read_date TIMESTAMP,
    file_size INT
);
```

#### Pending Friends Table
Keeps track of friend requests and their statuses.

```sql 
CREATE TABLE pending_friends (
    request_id SERIAL PRIMARY KEY,
    requester_id INT REFERENCES users(user_id) ON DELETE CASCADE,
    receiver_id INT REFERENCES users(user_id) ON DELETE CASCADE,
    status VARCHAR(20) CHECK (status IN ('pending', 'accepted', 'rejected')),
    request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    response_date TIMESTAMP
);
```