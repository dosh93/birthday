alter table public.config add name text;

UPDATE public.config SET name='Дней до дня рождения' WHERE key = 'dayTo';
UPDATE public.config SET name='Дней после дня рождения' WHERE key = 'dayAfter';