1. Consider the following schema:

	> Suppliers(<ins>_sid_</ins>, sname, address)
	> Parts(<ins>_pid_</ins>, pname, color)
	> Catalog(<ins>_sid_</ins>, <ins>_pid_</ins>, cos)

The key fields are underlined, and the domain of each field is listed after the field name. Therefore sid is the key for Suppliers, pid is the key for Parts, and sid and pid together form the key for Catalog. The Catalog relation lists the prices charged for parts by Suppliers. Write the following queries in **relational algebra**.

(a). Find the names of suppliers who supply some red part.
(b). Find the sids of suppliers who supply some red part or are at 221 Packer Street.
