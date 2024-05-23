import mysql.connector
from mysql.connector import Error
import threading

class DBConnection:
    _instance = None
    _lock = threading.Lock()
    
    #Singleton
    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            with cls._lock:
                if not cls._instance:
                    cls._instance = super(DBConnection, cls).__new__(cls, *args, **kwargs)
                    cls._instance._initialize_connection()
        return cls._instance
    
    def _initialize_connection(self):
        try:
            self.connection = mysql.connector.connect(
                host='localhost',
                database='university',
                user='root',
                password='hacha123'
            )
            if self.connection.is_connected():
                self.cursor = self.connection.cursor()
                # self._setup_database()
                print("Database connection successfully established.")
            else:
               print("Failed to establish database connection.")
        except Error as e:
            print(f"Error while connecting to MySQL: {e}")
            self.connection = None
            
    def get_connection(self):
        return self.connection

    def get_cursor(self):
        if self.connection and self.connection.is_connected():
            return self.connection.cursor()
        else:
            return None
            
    def close_connection(self):
        if self.connection.is_connected():
            self.cursor.close()
            self.connection.close()
            
        
    # def query(self, sql, params=None):
    #     if params is None:
    #         params = []
    #     self.cursor.execute(sql, params)
    #     self.connection.commit()
    #     return self.cursor
    
    
class UserService:
    def __init__(self, db_connection):
        self.db_connection = db_connection
        self.cursor = db_connection.get_cursor()

    def insert_user(self, ID, name):
        try:
            self.cursor.execute('INSERT INTO person (ID, name) VALUES (%s, %s)', (ID, name))
            self.db_connection.get_connection().commit()
        except Error as e:
            print(f"Failed to insert record into MySQL table {e}")

    def delete_user(self, user_id):
        try:
            self.cursor.execute('DELETE FROM users WHERE id = %s', (user_id,))
            self.db_connection.get_connection().commit()
        except Error as e:
            print(f"Failed to delete record from MySQL table {e}")

    def update_user(self, user_id, name=None, age=None):
        try:
            if name and age:
                self.cursor.execute('UPDATE users SET name = %s, age = %s WHERE id = %s', (name, age, user_id))
            elif name:
                self.cursor.execute('UPDATE users SET name = %s WHERE id = %s', (name, user_id))
            elif age:
                self.cursor.execute('UPDATE users SET age = %s WHERE id = %s', (age, user_id))
            self.db_connection.get_connection().commit()
        except Error as e:
            print(f"Failed to update record in MySQL table {e}")

    def fetch_users(self):
        self.cursor.execute('SELECT * FROM users')
        return self.cursor.fetchall()
   
    
    
            
if __name__ == "__main__":
    # Initialize the database connection
    db_connection = DBConnection()

    # Initialize the business logic class
    user_service = UserService(db_connection)

    # Insert a user
    user_service.insert_user('C123', "Chala")

    # # Update a user
    # user_service.update_user(1, name='Alice Smith', age=31)

    # # Delete a user
    # user_service.delete_user(1)

    # # Fetch users
    # users = user_service.fetch_users()
    # for user in users:
    #     print(user)

    # # Close the database connection
    # db_connection.close_connection()
