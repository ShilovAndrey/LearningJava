 
�������:

������� ����� CarType � �����������, ������������ �����, ��������, ����� �����.
��������� 3 ������� � ����.
�� ������������ ����� ������� � ������� �������� ������� �������, ����� ������� � ������ ����� ��������

��������:

1. ��������� ����� CarType, ����������� ��������� Serializable.
 - ����� �������� ����������: int power, String brand, String[] options.
 - ����� �������������� �����������, ����� ��� �������� ������� ������ ���������� ���� ����� ������� ��� ��������������
 - ����� ��������� ������� �� ������ ����������.

2. � �������� ������ ������� ������� ������ �������� � ����
 - ��������� �������������� ����� ��� ����� � ������ FileOutputStream.
 - �� ����������� � ������ ��������� ������� ObjectOutputStream, ������� ��������� ������� � ����.
 
3. � �������� ������ ������� ������� ���������� �������� �� �����
 - ��������� �������������� ����� ��� ����� � ������ � ���������� ���������� �� ���� FileInputStream
 - ��������� ������ ������� ����� ObjectInputStream
 - ��������� ���������� CarType ��� ������ � ��� ����������
 - �� ����� ��������� ���������� �� ������� ���������������� ���������� ������ �� �����, ����� �������